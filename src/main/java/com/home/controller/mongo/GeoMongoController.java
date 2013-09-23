package com.home.controller.mongo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.model.cloud.mongo.MongoCity;
import com.home.model.cloud.mongo.MongoCountry;
import com.home.model.cloud.mongo.MongoState;
import com.home.model.datatable.JQueryDataTableParameter;
import com.home.service.mongo.MongoDataTableService;

@Controller
@RequestMapping("/mongo/*")
public class GeoMongoController {
	private final Logger log = Logger.getLogger(GeoMongoController.class);
	
	private final MongoDataTableService<MongoState, Integer> mongoStateDataTableService;
	private final MongoDataTableService<MongoCountry, Integer> mongoCountryDataTableService;
	private final MongoDataTableService<MongoCity, Integer> mongoCityDataTableService;
	
	@Autowired
	public GeoMongoController(@Qualifier("mongoStateDataTableService") MongoDataTableService<MongoState, Integer> mongoStateDataTableService,
			@Qualifier("mongoCountryDataTableService") MongoDataTableService<MongoCountry, Integer> mongoCountryDataTableService,
			@Qualifier("mongoCityDataTableService") MongoDataTableService<MongoCity, Integer> mongoCityDataTableService) {
		super();
		this.mongoStateDataTableService=mongoStateDataTableService;
		this.mongoCountryDataTableService=mongoCountryDataTableService;
		this.mongoCityDataTableService=mongoCityDataTableService;
	}
	
	@RequestMapping(value="countryData", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String countryData(@ModelAttribute JQueryDataTableParameter parameters) {
		log.info("Getting Mongo country data");
		return mongoCountryDataTableService.getData(parameters).toString();
	}
	
	@RequestMapping(value="stateData", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String stateData(@ModelAttribute JQueryDataTableParameter parameters) {
		log.info("Getting Mongo state data");
		log.info(parameters);
		return mongoStateDataTableService.getData(parameters).toString();
	}
	
	@RequestMapping(value="cityData", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String cityData(@ModelAttribute JQueryDataTableParameter parameters) {
		log.info("Getting Mongo city data");
		log.info(parameters);
		return mongoCityDataTableService.getData(parameters).toString();
	}
	

}
