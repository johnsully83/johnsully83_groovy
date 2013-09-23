package com.home.service.mongo.implementations;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.dao.MongoDao;
import com.home.model.cloud.mongo.MongoCountry;
import com.home.model.datatable.JQueryDataTableParameter;
import com.home.model.datatable.structure.ColumnConfiguration;
import com.home.model.datatable.structure.enums.Searchable;
import com.home.model.datatable.structure.enums.Sortable;
import com.home.model.datatable.structure.enums.Visible;
import com.home.model.datatable.structure.simple.SimpleColumn;
import com.home.model.datatable.structure.simple.SimpleColumnConfiguration;
import com.home.model.datatable.view.MongoCountryView;
import com.home.service.mongo.AbstractMongoDataTableService;

@Service("mongoCountryDataTableService")
public class MongoCountryDataTableService extends AbstractMongoDataTableService<MongoCountry, Integer, MongoCountryView> {

	@Autowired
	public MongoCountryDataTableService(@Qualifier("countryMongoDao") MongoDao<MongoCountry, Integer> countryMongoDao) {
		super(countryMongoDao);
	}

	@Override
	protected List<MongoCountryView> convertNonEmptyDtosToViews(List<MongoCountry> records) {
		List<MongoCountryView> countryViews = new ArrayList<MongoCountryView>();
		
		for(MongoCountry country : records) {
			MongoCountryView countryView = new MongoCountryView(country);
			
			countryViews.add(countryView);
		}
		
		return countryViews;
	}

	@Override
	protected ColumnConfiguration convertEntityToColumns(MongoCountryView row) {
		ColumnConfiguration columnConfig = new SimpleColumnConfiguration();

		columnConfig.setColumn(0, new SimpleColumn(Visible.YES, Sortable.YES, row.getName(),
			Searchable.YES, row.getName()));
		columnConfig.setColumn(1, new SimpleColumn(Visible.YES, Sortable.YES, row.getHasStates(),
				Searchable.YES, row.getHasStates()));
		
		return columnConfig;
	}

	@Override
	protected List<MongoCountry> query(JQueryDataTableParameter parameters) {
		return getMongoDao().findAll();
	}

	@Override
	protected JSONArray convertTableRowsToJsonArray(List<MongoCountryView> tableRows) {
		JSONArray jsonArray = new JSONArray();

		for (MongoCountryView row : tableRows) {
			JSONArray tableRow = new JSONArray();

			tableRow.put("<div class='countryID' id='"+row.getCountryID()+"'>"+row.getName()+"</div>");
			tableRow.put(row.getHasStates());

			jsonArray.put(tableRow);
		}

		return jsonArray;
	}

}
