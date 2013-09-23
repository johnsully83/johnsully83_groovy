package com.home.service.mongo;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.home.dao.MongoDao;
import com.home.model.cloud.MongoCloudTable;
import com.home.model.datatable.JQueryDataTableParameter;
import com.home.model.datatable.structure.Column;
import com.home.model.datatable.structure.ColumnConfiguration;

public abstract class AbstractMongoDataTableService<T extends MongoCloudTable<PK>, PK extends Comparable<PK>, VIEW> implements
		MongoDataTableService<T, PK> {
	private final Logger log = Logger.getLogger(AbstractMongoDataTableService.class);
	
	private final MongoDao<T, PK> mongoDao;
	
	protected AbstractMongoDataTableService(MongoDao<T, PK> mongoDao) {
		super();
		this.mongoDao=mongoDao;
	}
	
	protected abstract List<VIEW> convertNonEmptyDtosToViews(List<T> records);
	
	protected abstract ColumnConfiguration convertEntityToColumns(VIEW row);
	
	protected abstract List<T> query(JQueryDataTableParameter parameters);

	@Override
	public JSONObject getData(JQueryDataTableParameter parameters) {
		List<VIEW> allTableRows = findAll(parameters);

		parameters.setiTotalRecords(allTableRows.size());
		
		List<VIEW> filterRows = filterRows(allTableRows, parameters);
		
		parameters.setiTotalDisplayRecords(filterRows.size());
		
		sortRows(filterRows, parameters);
		
		filterRows = handlePagination(filterRows, parameters);

		JSONObject jsonObject = new JSONObject();
		
		try {
			jsonObject = constructJsonObjectResponseFromTableRows(filterRows, parameters);
		} catch (JSONException e) {
			log.error("Error constructing JSONObject", e);
		}

		return jsonObject;
	}

	protected List<VIEW> findAll(JQueryDataTableParameter parameters) {
		List<T> results = query(parameters);
		
		if(!results.isEmpty()) {
			return convertNonEmptyDtosToViews(results);
		} else {
			return Collections.<VIEW>emptyList();
		}
	}
	
	protected List<VIEW> filterRows(List<VIEW> allTableRows, JQueryDataTableParameter parameters) {
		String quickSearch = parameters.getsSearch();
		
		List<VIEW> filterRows = new ArrayList<VIEW>();
		
		Boolean searchTextIsEmpty = searchTextIsEmpty(quickSearch);
		quickSearch = quickSearch.toLowerCase();

		for (VIEW row : allTableRows) {
			
			if (searchTextIsEmpty) {
				filterRows.add(row);
				continue;
			}

			ColumnConfiguration columnConfiguration = convertEntityToColumns(row);

			for (Column column : columnConfiguration.getColumnConfigMap().values()) {
				if (valueInSearch(column.getValue(), quickSearch) && column.getSearchable()) {
					filterRows.add(row);
					break;
				}
			}
		}

		return filterRows;
	}
	
	protected boolean searchTextIsEmpty(String quickSearch) {
		if (quickSearch == null || quickSearch.trim().length() == 0) {
			return true;
		}
		
		return false;
	}

	protected boolean valueInSearch(Object value, String searchString) {
		if (value == null) {
			return false;
		}

		if (searchString == null || "".equals(searchString)) {
			return true;
		}

		String stringValue = value.toString();
		if (stringValue.toLowerCase().trim().contains(searchString.toLowerCase())) {
			return true;
		}
		
		return false;
	}

	protected void sortRows(List<VIEW> filterRows, final JQueryDataTableParameter parameters) {
		Collections.sort(filterRows, new Comparator<VIEW>() {
			@Override
			public int compare(VIEW rowOne, VIEW rowTwo) {
				return compareTwoRows(rowOne, rowTwo, parameters);
			}
		});
	}

	private int compareTwoRows(VIEW rowOne, VIEW rowTwo, JQueryDataTableParameter param) {
		Integer sortColumnIndex = param.getiSortCol_0();
		Integer sortDirection = param.getsSortDir_0().equals("asc") ? -1 : 1;

		Object valueFromRowOne = convertEntityToColumns(rowOne).getColumn(sortColumnIndex).getValue();
		Object valueFromRowTwo = convertEntityToColumns(rowTwo).getColumn(sortColumnIndex).getValue();

		if (valueFromRowOne instanceof Date) {
			Date a = (Date) valueFromRowOne;
			Date b = (Date) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof java.sql.Date) {
			java.sql.Date a = (java.sql.Date) valueFromRowOne;
			java.sql.Date b = (java.sql.Date) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Timestamp) {
			Timestamp a = (Timestamp) valueFromRowOne;
			Timestamp b = (Timestamp) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Time) {
			Time a = (Time) valueFromRowOne;
			Time b = (Time) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Character) {
			Character a = (Character) valueFromRowOne;
			Character b = (Character) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof String) {
			String a = (String) valueFromRowOne;
			String b = (String) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Short) {
			Short a = (Short) valueFromRowOne;
			Short b = (Short) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Integer) {
			Integer a = (Integer) valueFromRowOne;
			Integer b = (Integer) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Long) {
			Long a = (Long) valueFromRowOne;
			Long b = (Long) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof BigDecimal) {
			BigDecimal a = (BigDecimal) valueFromRowOne;
			BigDecimal b = (BigDecimal) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Double) {
			Double a = (Double) valueFromRowOne;
			Double b = (Double) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Float) {
			Float a = (Float) valueFromRowOne;
			Float b = (Float) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}
		if (valueFromRowOne instanceof Boolean) {
			Boolean a = (Boolean) valueFromRowOne;
			Boolean b = (Boolean) valueFromRowTwo;
			return a.compareTo(b) * sortDirection;
		}

		return 0;
	}

	protected List<VIEW> handlePagination(List<VIEW> filterRows, JQueryDataTableParameter parameters) {
		Integer displayFromThisRow = parameters.getiDisplayStart();
		Integer numberOfRowsToDisplay = parameters.getiDisplayLength();

		if (filterRows.size() < displayFromThisRow + numberOfRowsToDisplay) {
			filterRows = filterRows.subList(displayFromThisRow, filterRows.size());
		} else {
			filterRows = filterRows.subList(displayFromThisRow, displayFromThisRow + numberOfRowsToDisplay);
		}

		return filterRows;
	}

	protected JSONObject constructJsonObjectResponseFromTableRows(List<VIEW> filterRows, JQueryDataTableParameter parameters)
			throws JSONException {
		JSONArray jsonArray = convertTableRowsToJsonArray(filterRows);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("sEcho", parameters.getsEcho());
		jsonObject.put("iTotalRecords", parameters.getiTotalRecords());
		jsonObject.put("iTotalDisplayRecords", parameters.getiTotalDisplayRecords());
		jsonObject.put("aaData", jsonArray);
		
		return jsonObject;
	}
	
	protected JSONArray convertTableRowsToJsonArray(List<VIEW> tableRows) {
		JSONArray jsonArray = new JSONArray();

		for (VIEW row : tableRows) {
			JSONArray tableRow = new JSONArray();

			ColumnConfiguration columnConfiguration = convertEntityToColumns(row);

			for (Column column : columnConfiguration.getColumnConfigMap().values()) {
				try {
					tableRow.put(new String(column.getDisplayValue().getBytes("UTF-8"), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					tableRow.put(column.getDisplayValue());
				}
			}

			jsonArray.put(tableRow);
		}

		return jsonArray;
	}

	public Logger getLog() {
		return log;
	}

	public MongoDao<T, PK> getMongoDao() {
		return mongoDao;
	}

}
