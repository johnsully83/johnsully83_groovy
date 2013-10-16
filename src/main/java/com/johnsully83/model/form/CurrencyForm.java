package com.johnsully83.model.form;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CurrencyForm {

	private Integer timestamp;
	private String fromCurrencyCode;
	private String toCurrencyCode;
	private BigDecimal amountFrom;
	private BigDecimal value;
	
	public CurrencyForm() {
		super();
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}
	
	@NotNull
	@Min(value=0)
	public BigDecimal getAmountFrom() {
		return amountFrom;
	}

	public void setAmountFrom(BigDecimal amountFrom) {
		this.amountFrom = amountFrom;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
