package com.home.service.workflow.helper.city;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.home.AppContext;
import com.home.dao.MongoDao;
import com.home.exceptions.implementations.NoStateFoundException;
import com.home.model.cloud.jpa.City;
import com.home.model.cloud.jpa.Country;
import com.home.model.cloud.jpa.State;
import com.home.model.cloud.mongo.MongoCity;
import com.home.model.cloud.mongo.MongoCountry;
import com.home.model.cloud.mongo.MongoState;
import com.home.model.enumeration.geoplanet.GeoPlanetPlaceType;
import com.home.service.model.DtoService;
import com.home.service.workflow.helper.AbstractWorkflowHelperService;
import com.home.workflow.traversing.implementations.CityTraverser;
import com.jgeoplanet.GeoPlanet;
import com.jgeoplanet.GeoPlanetException;
import com.jgeoplanet.Place;
import com.jgeoplanet.PlaceCollection;

public class CityWorkflowHelperService extends AbstractWorkflowHelperService<City, Integer> {
	private final Logger log = Logger.getLogger(CityWorkflowHelperService.class);

	private final GeoPlanet geoPlanetApi;
	private final MongoDao<MongoCity, Integer> cityMongoDao;
	private final MongoDao<MongoState, Integer> stateMongoDao;
	private final MongoDao<MongoCountry, Integer> countryMongoDao;
	private final DtoService<State, Integer> stateDtoService;
	private final DtoService<Country, Integer> countryDtoService;

	@SuppressWarnings("unchecked")
	public CityWorkflowHelperService() {
		super(AppContext.getApplicationContext().getBean("cityDtoService", DtoService.class));
		this.geoPlanetApi=AppContext.getApplicationContext().getBean("geoPlanetApi", GeoPlanet.class);
		this.cityMongoDao=AppContext.getApplicationContext().getBean("cityMongoDao", MongoDao.class);
		this.stateDtoService=AppContext.getApplicationContext().getBean("stateDtoService", DtoService.class);
		this.countryDtoService=AppContext.getApplicationContext().getBean("countryDtoService", DtoService.class);
		this.stateMongoDao=AppContext.getApplicationContext().getBean("stateMongoDao", MongoDao.class);
		this.countryMongoDao=AppContext.getApplicationContext().getBean("countryMongoDao", MongoDao.class);
	}

	public void queryForCities(CityTraverser tasks) throws GeoPlanetException {
		Place earth = geoPlanetApi.getPlace(1);
		PlaceCollection countries = earth.getChildren().type(GeoPlanetPlaceType.COUNTRY.getName());

		Map<Place, List<Place>> stateMap = new LinkedHashMap<Place, List<Place>>();

		for(Place country : countries.get()) {
			if(!country.getName().equalsIgnoreCase(tasks.getWorkflowHelperWrapper().getNextCountry().getName())) {
				continue;
			}

			List<Country> countryDtos = countryDtoService.query("name = '"+country.getName().replaceAll("'", "''")+"'");

			if(countryDtos.isEmpty()) {
				log.error("Could not find country DTO with name "+country.getName()+" even though there is a Yahoo! record for it.");
				continue;
			} else {
				if(!countryDtos.get(0).getHasStates()) {
					continue;
				}
			}

			List<Place> states = country.getChildren().type(GeoPlanetPlaceType.STATE.getName()).get();
			
			for(Place state : states) {
				List<Place> subAreas = getSafely(state, GeoPlanetPlaceType.COUNTY.getName());
				
				List<Place> subAreasToAdd = new ArrayList<Place>();
				
				for(Place county : subAreas) {
					subAreasToAdd.addAll(getSafely(county, GeoPlanetPlaceType.LOCALADMINISTRATIVEAREA.getName()));
				}
				
				subAreas.addAll(subAreasToAdd);
				subAreas.addAll(getSafely(state, GeoPlanetPlaceType.LOCALADMINISTRATIVEAREA.getName()));
				
				List<Place> cities = new ArrayList<Place>();
				
				cities.addAll(getSafely(state, GeoPlanetPlaceType.TOWN.getName()));
				
				for(Place subArea : subAreas) {
					cities.addAll(getSafely(subArea, GeoPlanetPlaceType.TOWN.getName()));
				}
				
				stateMap.put(state, cities);
				
				if(country.getName().equalsIgnoreCase("United States")) {
					log.info(state.getName()+" has "+cities.size()+" cities");
				}
			}
		}
		
		tasks.getWorkflowHelperWrapper().setGeoPlanetCities(stateMap);
	}

	private List<Place> getSafely(Place place, String name) {
		try {
			List<Place> places = place.getChildren().type(name).get(); 
			
			return places;
		} catch(GeoPlanetException e) {
			return Collections.<Place>emptyList();
		}
	}

	public void convertCitiesAndMerge(CityTraverser tasks) throws NoStateFoundException {
		Integer numberOfStatesWithoutCities = 0;
		for(Map.Entry<Place, List<Place>> entry : tasks.getWorkflowHelperWrapper().getGeoPlanetCities().entrySet()) {
			Place state = entry.getKey();
			List<Place> cities = entry.getValue();

			List<State> results = stateDtoService.query("name = '"+state.getName().replaceAll("'", "''")+"'");

			if(results.isEmpty()) {
				throw new NoStateFoundException(state);
			}

			State stateDto = results.get(0);

			if(cities.isEmpty()) {
				numberOfStatesWithoutCities++;
			}

			for(Place city : cities) {
				City cityDto = new City();

				List<City> queryCheck = query("name = '"+city.getName().replaceAll("'", "''")+"'");

				if(queryCheck.isEmpty()) {
					cityDto.setName(city.getName());
					cityDto.setState(stateDto);
					cityDto.setCountry(stateDto.getCountry());

					add(cityDto);
					tasks.getWorkflowHelperWrapper().getAllEntities().add(cityDto);
					continue;
				}

				cityDto = queryCheck.get(0);

				cityDto.setCountry(stateDto.getCountry());
				cityDto.setState(stateDto);
				cityDto.setDateLastModified(new Date());
				cityDto.setIsDeleted(false);

				cityDto = merge(cityDto);

				tasks.getWorkflowHelperWrapper().getAllEntities().add(cityDto);
			}
		}


		log.info("numberOfStatesWithoutCities: "+numberOfStatesWithoutCities);
	}

	public void replicateToMongoDB(CityTraverser tasks) {
		List<City> cities = tasks.getWorkflowHelperWrapper().getAllEntities();

		for(City city : cities) {
			MongoCity mongoCity= new MongoCity();

			mongoCity.setName(city.getName());
			mongoCity.setId(city.getPk());

			MongoState state = stateMongoDao.find(city.getState().getPk());
			MongoCountry country = countryMongoDao.find(city.getCountry().getPk());

			mongoCity.setState(state);
			mongoCity.setCountry(country);

			mongoCity.setId(city.getPk());

			cityMongoDao.merge(mongoCity);
		}
	}

}
