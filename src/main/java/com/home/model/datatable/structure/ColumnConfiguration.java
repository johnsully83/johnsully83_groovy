package com.home.model.datatable.structure;

import java.util.TreeMap;

public interface ColumnConfiguration {

	public Column getColumn(Integer columnPosition);
	
	public void setColumn(Integer columnPosition, Column column);

	public TreeMap<Integer, Column> getColumnConfigMap();

}
