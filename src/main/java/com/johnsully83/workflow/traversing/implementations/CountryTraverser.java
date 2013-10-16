package com.johnsully83.workflow.traversing.implementations;

import com.johnsully83.model.cloud.jpa.Country;
import com.johnsully83.service.workflow.helper.country.CountryWorkflowHelperService;
import com.johnsully83.service.workflow.helper.country.CountryWorkflowHelperWrapper;
import com.johnsully83.workflow.traversing.AbstractTraverser;

public class CountryTraverser extends AbstractTraverser<CountryWorkflowHelperService, CountryWorkflowHelperWrapper,
	Country, Integer> {

	public CountryTraverser() {
		super(new CountryWorkflowHelperService(), new CountryWorkflowHelperWrapper());
	}

}
