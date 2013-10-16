package com.johnsully83.workflow.traversing.implementations;

import com.johnsully83.model.cloud.jpa.LatestRates;
import com.johnsully83.service.workflow.helper.currency.CurrencyWorkflowHelperService;
import com.johnsully83.service.workflow.helper.currency.CurrencyWorkflowHelperWrapper;
import com.johnsully83.workflow.traversing.AbstractTraverser;

public class CurrencyTraverser extends
		AbstractTraverser<CurrencyWorkflowHelperService, CurrencyWorkflowHelperWrapper, LatestRates, Integer> {

	public CurrencyTraverser() {
		super(new CurrencyWorkflowHelperService(), new CurrencyWorkflowHelperWrapper());
	}

}
