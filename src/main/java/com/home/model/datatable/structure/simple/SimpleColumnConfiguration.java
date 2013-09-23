package com.home.model.datatable.structure.simple;

import java.util.TreeMap;

import com.home.model.datatable.structure.Column;
import com.home.model.datatable.structure.ColumnConfiguration;

public class SimpleColumnConfiguration implements ColumnConfiguration {

	private TreeMap<Integer, Column> columnConfigMap;

	public SimpleColumnConfiguration() {
		super();
		columnConfigMap = new TreeMap<Integer, Column>();
	}

	@Override
	public Column getColumn(Integer columnPosition) {
		return columnConfigMap.get(columnPosition);
	}
	
	public void setColumn(Integer columnPosition, Column column) {
		columnConfigMap.put(columnPosition, column);
	}

	@Override
	public TreeMap<Integer, Column> getColumnConfigMap() {
		return columnConfigMap;
	}

}
