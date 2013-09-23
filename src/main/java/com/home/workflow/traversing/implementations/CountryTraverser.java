package com.home.workflow.traversing.implementations;

import com.home.model.cloud.jpa.Country;
import com.home.service.workflow.helper.country.CountryWorkflowHelperService;
import com.home.service.workflow.helper.country.CountryWorkflowHelperWrapper;
import com.home.workflow.traversing.AbstractTraverser;

public class CountryTraverser extends AbstractTraverser<CountryWorkflowHelperService, CountryWorkflowHelperWrapper,
	Country, Integer> {

	public CountryTraverser() {
		super(new CountryWorkflowHelperService(), new CountryWorkflowHelperWrapper());
	}

}
