package com.johnsully83.service.workflow.helper.state;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jgeoplanet.GeoPlanet;
import com.jgeoplanet.GeoPlanetException;
import com.jgeoplanet.Place;
import com.jgeoplanet.PlaceCollection;
import com.johnsully83.AppContext;
import com.johnsully83.dao.MongoDao;
import com.johnsully83.exceptions.implementations.NoCountryFoundException;
import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.model.cloud.jpa.State;
import com.johnsully83.model.cloud.mongo.MongoCountry;
import com.johnsully83.model.cloud.mongo.MongoState;
import com.johnsully83.model.enumeration.geoplanet.GeoPlanetPlaceType;
import com.johnsully83.service.model.DtoService;
import com.johnsully83.service.workflow.helper.AbstractWorkflowHelperService;
import com.johnsully83.workflow.traversing.implementations.StateTraverser;

public class StateWorkflowHelperService extends AbstractWorkflowHelperService<State, Integer> {
	private final Logger log = Logger.getLogger(StateWorkflowHelperService.class);

	private final GeoPlanet geoPlanetApi;
	private final DtoService<Country, Integer> countryDtoService;
	private final MongoDao<MongoState, Integer> stateMongoDao;
	private final MongoDao<MongoCountry, Integer> countryMongoDao;

	@SuppressWarnings("unchecked")
	public StateWorkflowHelperService() {
		super(AppContext.getApplicationContext().getBean("stateDtoService", DtoService.class));
		this.countryDtoService=AppContext.getApplicationContext().getBean("countryDtoService", DtoService.class);
		this.geoPlanetApi=AppContext.getApplicationContext().getBean("geoPlanetApi", GeoPlanet.class);
		this.stateMongoDao=AppContext.getApplicationContext().getBean("stateMongoDao", MongoDao.class);
		this.countryMongoDao=AppContext.getApplicationContext().getBean("countryMongoDao", MongoDao.class);
	}

	public void queryForStates(StateTraverser tasks) throws GeoPlanetException {
		Place earth = geoPlanetApi.getPlace(1);
		PlaceCollection countries = earth.getChildren().type(GeoPlanetPlaceType.COUNTRY.getName());

		Map<Place, List<Place>> stateMap = new LinkedHashMap<Place, List<Place>>();

		for(Place country : countries.get()) {
			try {
				PlaceCollection states = country.getChildren().type(GeoPlanetPlaceType.STATE.getName());

				stateMap.put(country, states.get());
			} catch(GeoPlanetException e) {
				stateMap.put(country, Collections.<Place>emptyList());
				continue;
			}
		}

		tasks.getWorkflowHelperWrapper().setGeoPlanetStates(stateMap);
	}

	public void convertStatesAndMerge(StateTraverser tasks) throws NoCountryFoundException {
		Integer numberOfCountriesWithoutStates = 0;
		for(Map.Entry<Place, List<Place>> entry : tasks.getWorkflowHelperWrapper().getGeoPlanetStates().entrySet()) {
			Place country = entry.getKey();
			List<Place> states = entry.getValue();

			List<Country> results = countryDtoService.query("name = '"+country.getName()+"'");

			if(results.isEmpty()) {
				throw new NoCountryFoundException(country);
			}

			Country countryDto = results.get(0);
			if((states.isEmpty() && countryDto.getHasStates()) || (!states.isEmpty() && !countryDto.getHasStates())) {
				countryDto.setHasStates(!states.isEmpty());
				countryDto = countryDtoService.merge(countryDto);
			}

			if(states.isEmpty()) {
				numberOfCountriesWithoutStates++;
			}

			for(Place state : states) {
				State stateDto = new State();

				List<State> queryCheck = query("name = '"+state.getName().replaceAll("'", "''")+"'");

				if(queryCheck.isEmpty()) {
					stateDto.setName(state.getName());
					stateDto.setCountry(countryDto);

					add(stateDto);
					tasks.getWorkflowHelperWrapper().getAllEntities().add(stateDto);
					continue;
				}

				stateDto = queryCheck.get(0);

				stateDto.setCountry(countryDto);
				stateDto.setDateLastModified(new Date());
				stateDto.setIsDeleted(false);

				stateDto = merge(stateDto);

				tasks.getWorkflowHelperWrapper().getAllEntities().add(stateDto);
			}
		}


		log.info("numberOfCountriesWithoutStates: "+numberOfCountriesWithoutStates);
	}

	public void replicateToMongoDB(StateTraverser tasks) {
		List<State> states = tasks.getWorkflowHelperWrapper().getAllEntities();
		
		for(State state : states) {
			MongoState mongoState = new MongoState();
			
			mongoState.setName(state.getName());
			mongoState.setId(state.getPk());
			
			MongoCountry country = countryMongoDao.find(state.getCountry().getPk());
			
			mongoState.setCountry(country);
			
			mongoState.setId(state.getPk());
			
			stateMongoDao.merge(mongoState);
		}
	}

}
