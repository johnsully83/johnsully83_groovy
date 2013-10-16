package com.johnsully83.model.datatable.structure.enums;

public enum Editable  {

	YES(true), NO(false);

	private final boolean value;

	Editable(boolean value) {
		this.value = value;
	}

	public boolean getBooleanValue() {
		return value;
	}

}
