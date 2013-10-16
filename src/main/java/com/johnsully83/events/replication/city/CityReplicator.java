package com.johnsully83.events.replication.city;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.events.replication.AbstractReplicator;
import com.johnsully83.exceptions.implementations.NoCountryFoundException;
import com.johnsully83.model.cloud.jpa.City;
import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.service.model.DtoService;
import com.johnsully83.workflow.node.Node;
import com.johnsully83.workflow.traversing.implementations.CityTraverser;

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
