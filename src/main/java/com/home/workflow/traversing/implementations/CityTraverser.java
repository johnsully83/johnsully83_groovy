package com.home.workflow.traversing.implementations;

import com.home.model.cloud.jpa.City;
import com.home.model.cloud.jpa.Country;
import com.home.service.workflow.helper.city.CityWorkflowHelperService;
import com.home.service.workflow.helper.city.CityWorkflowHelperWrapper;
import com.home.workflow.traversing.AbstractTraverser;

public class CityTraverser extends AbstractTraverser<CityWorkflowHelperService, CityWorkflowHelperWrapper, City, Integer> {

	public CityTraverser(Country country) {
		super(new CityWorkflowHelperService(), new CityWorkflowHelperWrapper(country));
	}
	
}
