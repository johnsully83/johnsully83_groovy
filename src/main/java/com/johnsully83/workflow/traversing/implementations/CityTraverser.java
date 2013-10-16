package com.johnsully83.workflow.traversing.implementations;

import com.johnsully83.model.cloud.jpa.City;
import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.service.workflow.helper.city.CityWorkflowHelperService;
import com.johnsully83.service.workflow.helper.city.CityWorkflowHelperWrapper;
import com.johnsully83.workflow.traversing.AbstractTraverser;

public class CityTraverser extends AbstractTraverser<CityWorkflowHelperService, CityWorkflowHelperWrapper, City, Integer> {

	public CityTraverser(Country country) {
		super(new CityWorkflowHelperService(), new CityWorkflowHelperWrapper(country));
	}
	
}
