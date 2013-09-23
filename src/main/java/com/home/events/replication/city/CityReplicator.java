package com.home.events.replication.city;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.events.replication.AbstractReplicator;
import com.home.exceptions.implementations.NoCountryFoundException;
import com.home.model.cloud.jpa.City;
import com.home.model.cloud.jpa.Country;
import com.home.service.model.DtoService;
import com.home.workflow.node.Node;
import com.home.workflow.traversing.implementations.CityTraverser;

@Service("cityReplicator")
public class CityReplicator extends AbstractReplicator<CityTraverser, City, Integer> {
	private final Logger log = Logger.getLogger(CityReplicator.class);

	private final DtoService<Country, Integer> countryDtoService;
	
	private Integer nextMinimumCountryID;
	
	@Autowired
	protected CityReplicator(@Qualifier("cityReplicationWorkflow") Node<CityTraverser> startNode,
			@Qualifier("countryDtoService") DtoService<Country, Integer> countryDtoService) {
		super(startNode);
		this.countryDtoService=countryDtoService;
		this.nextMinimumCountryID=0;
	}

	@Override
	public void replicate() {
		while(true) {
			try {
				
				Country nextCountry = getNextCountry();

				log.info("Beginning city replication for country "+nextCountry.getName()+"...");
				
				getStartNode().start(new CityTraverser(nextCountry));

				log.info("Ending city replication for country "+nextCountry.getName()+"...");
			} catch (NoCountryFoundException e) {
				break;
			}
		}
	}

	private Country getNextCountry() throws NoCountryFoundException {
		List<Country> allCountries = countryDtoService.query("pk > "+nextMinimumCountryID, "pk ASC");
		
		if(allCountries.isEmpty()) {
			throw new NoCountryFoundException("");
		}
		
		Country nextCountry = allCountries.get(0);
		
		this.nextMinimumCountryID = nextCountry.getPk();
		
		return nextCountry;
	}

}
