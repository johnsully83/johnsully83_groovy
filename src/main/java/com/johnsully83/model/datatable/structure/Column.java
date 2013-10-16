package com.johnsully83.model.datatable.structure;


public interface Column {

	public Boolean getVisable();
	
	public Boolean getSortable();
	
	public Object getValue();
	
	public String getDisplayValue();
	
	public Boolean getSearchable();

}
