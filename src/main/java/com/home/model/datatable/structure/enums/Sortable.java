package com.home.model.datatable.structure.enums;

public enum Sortable  {

	YES(true), NO(false);

	private final boolean value;

	Sortable(boolean value) {
		this.value = value;
	}

	public boolean getBooleanValue() {
		return value;
	}

}
