package com.johnsully83.service.workflow.helper.country;

import java.util.Date;
import java.util.List;

import com.jgeoplanet.GeoPlanet;
import com.jgeoplanet.GeoPlanetException;
import com.jgeoplanet.Place;
import com.jgeoplanet.PlaceCollection;
import com.johnsully83.AppContext;
import com.johnsully83.dao.MongoDao;
import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.model.cloud.mongo.MongoCountry;
import com.johnsully83.model.enumeration.geoplanet.GeoPlanetPlaceType;
import com.johnsully83.service.model.DtoService;
import com.johnsully83.service.workflow.helper.AbstractWorkflowHelperService;
import com.johnsully83.workflow.traversing.implementations.CountryTraverser;

public class CountryWorkflowHelperService extends AbstractWorkflowHelperService<Country, Integer> {
	private final GeoPlanet geoPlanetApi;
	private final MongoDao<MongoCountry, Integer> countryMongoDao;

	@SuppressWarnings("unchecked")
	public CountryWorkflowHelperService() {
		super(AppContext.getApplicationContext().getBean("countryDtoService", DtoService.class));
		this.geoPlanetApi=AppContext.getApplicationContext().getBean("geoPlanetApi", GeoPlanet.class);
		this.countryMongoDao=AppContext.getApplicationContext().getBean("countryMongoDao", MongoDao.class);
	}
	
	public void queryForCountries(CountryTraverser tasks) throws GeoPlanetException {
		Place earth = geoPlanetApi.getPlace(1);
		PlaceCollection countries = earth.getChildren().type(GeoPlanetPlaceType.COUNTRY.getName());
		
		tasks.getWorkflowHelperWrapper().setGeoPlanetCountries(countries.get());
	}
	
	public void convertCountriesAndMerge(CountryTraverser tasks) {
		List<Place> countries = tasks.getWorkflowHelperWrapper().getGeoPlanetCountries();
		
		for(Place country : countries) {
			Country countryDto = new Country();
			
			List<Country> countryDtos = query("name = '"+country.getName()+"'");
			
			if(countryDtos.isEmpty()) {
				countryDto.setName(country.getName());
				
				add(countryDto);

				tasks.getWorkflowHelperWrapper().getAllEntities().add(countryDto);
				continue;
			}
			
			countryDto = countryDtos.get(0);
			countryDto.setDateLastModified(new Date());
			countryDto.setIsDeleted(false);
			
			countryDto = merge(countryDto);
			
			tasks.getWorkflowHelperWrapper().getAllEntities().add(countryDto);
		}
		
	}
	
	public void replicateToMongoDB(CountryTraverser tasks) {
		List<Country> countries = tasks.getWorkflowHelperWrapper().getAllEntities();
		
		for(Country country : countries) {
			MongoCountry mongoCountry = new MongoCountry();
			
			mongoCountry.setHasStates(country.getHasStates());
			mongoCountry.setName(country.getName());
			mongoCountry.setId(country.getPk());
			
			mongoCountry.setId(country.getPk());
			
			countryMongoDao.merge(mongoCountry);
		}
	}

}
