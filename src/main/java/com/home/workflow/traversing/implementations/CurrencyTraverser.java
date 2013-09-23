package com.home.workflow.traversing.implementations;

import com.home.model.cloud.jpa.LatestRates;
import com.home.service.workflow.helper.currency.CurrencyWorkflowHelperService;
import com.home.service.workflow.helper.currency.CurrencyWorkflowHelperWrapper;
import com.home.workflow.traversing.AbstractTraverser;

public class CurrencyTraverser extends
		AbstractTraverser<CurrencyWorkflowHelperService, CurrencyWorkflowHelperWrapper, LatestRates, Integer> {

	public CurrencyTraverser() {
		super(new CurrencyWorkflowHelperService(), new CurrencyWorkflowHelperWrapper());
	}

}
