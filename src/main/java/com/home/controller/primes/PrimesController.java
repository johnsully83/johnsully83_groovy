package com.home.controller.primes;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.exceptions.SullyException;
import com.home.model.cloud.mongo.MongoPrime;
import com.home.model.datatable.JQueryDataTableParameter;
import com.home.service.mongo.MongoDataTableService;
import com.home.service.primes.PrimesService;

@Controller
@RequestMapping("/primes/*")
public class PrimesController {
	private final Logger log = Logger.getLogger(PrimesController.class);

	private final MongoDataTableService<MongoPrime, Integer> mongoPrimeRangeDataTableService;
	private final MongoDataTableService<MongoPrime, Integer> mongoPrimeDataTableService;
	private final PrimesService primesService;
	
	@Autowired
	public PrimesController(@Qualifier("mongoPrimeRangeDataTableService") MongoDataTableService<MongoPrime, Integer> mongoPrimeRangeDataTableService,
			@Qualifier("mongoPrimeDataTableService") MongoDataTableService<MongoPrime, Integer> mongoPrimeDataTableService,
			PrimesService primesService) {
		super();
		this.mongoPrimeRangeDataTableService=mongoPrimeRangeDataTableService;
		this.mongoPrimeDataTableService=mongoPrimeDataTableService;
		this.primesService=primesService;
	}
	
	@RequestMapping(value="primeData", method={RequestMethod.POST}, produces="application/json")
	@ResponseBody
	public String getPrimeData(HttpServletRequest request, @ModelAttribute JQueryDataTableParameter parameters) throws SullyException, JSONException {
		log.info("Getting prime data...");
		return mongoPrimeDataTableService.getData(parameters).toString();
	}
	
	@RequestMapping(value="primeRangeData", method={RequestMethod.POST}, produces="application/json")
	@ResponseBody
	public String getPrimeRangeData(HttpServletRequest request, @ModelAttribute JQueryDataTableParameter parameters) throws SullyException, JSONException {
		log.info("Getting prime range data:" + parameters);
		return mongoPrimeRangeDataTableService.getData(parameters).toString();
	}
	
	@RequestMapping(value="findPrime", method={RequestMethod.GET}, produces="text/plain")
	@ResponseBody
	public String findPrime(HttpServletRequest request, @ModelAttribute JQueryDataTableParameter parameters) throws SullyException {
		return primesService.findPrime(parameters).toString();
	}
	
}
