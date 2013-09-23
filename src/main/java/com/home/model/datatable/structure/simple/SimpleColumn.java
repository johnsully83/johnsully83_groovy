package com.home.model.datatable.structure.simple;

import com.home.model.datatable.structure.Column;
import com.home.model.datatable.structure.enums.Searchable;
import com.home.model.datatable.structure.enums.Sortable;
import com.home.model.datatable.structure.enums.Visible;

public final class SimpleColumn implements Column {
	private final Boolean visable;
	private final Boolean sortable;
	private final Object value;
	private final String displayValue;
	private final Boolean searchable;

	public SimpleColumn(Visible visible, Sortable sortable, Object value, Searchable searchable, String displayValue) {
		super();
		this.visable = visible.getBooleanValue();
		this.sortable = sortable.getBooleanValue();
		this.value = value;
		this.searchable = searchable.getBooleanValue();
		this.displayValue = displayValue;
	}

	@Override
	public Boolean getVisable() {
		return visable;
	}

	@Override
	public Boolean getSortable() {
		return sortable;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public String getDisplayValue() {
		return displayValue;
	}

	@Override
	public Boolean getSearchable() {
		return searchable;
	}
	
}
