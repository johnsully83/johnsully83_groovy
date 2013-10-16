package com.johnsully83.service.mongo.implementations;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.MongoDao;
import com.johnsully83.model.cloud.mongo.MongoState;
import com.johnsully83.model.datatable.JQueryDataTableParameter;
import com.johnsully83.model.datatable.structure.ColumnConfiguration;
import com.johnsully83.model.datatable.structure.enums.Searchable;
import com.johnsully83.model.datatable.structure.enums.Sortable;
import com.johnsully83.model.datatable.structure.enums.Visible;
import com.johnsully83.model.datatable.structure.simple.SimpleColumn;
import com.johnsully83.model.datatable.structure.simple.SimpleColumnConfiguration;
import com.johnsully83.model.datatable.view.MongoStateView;
import com.johnsully83.service.mongo.AbstractMongoDataTableService;

@Service("mongoStateDataTableService")
public class MongoStateDataTableService extends AbstractMongoDataTableService<MongoState, Integer, MongoStateView> {
	
	@Autowired
	public MongoStateDataTableService(@Qualifier("stateMongoDao") MongoDao<MongoState, Integer> stateMongoDao) {
		super(stateMongoDao);
	}

	@Override
	protected List<MongoStateView> convertNonEmptyDtosToViews(List<MongoState> records) {
		List<MongoStateView> stateViews = new ArrayList<MongoStateView>();
		
		for(MongoState state : records) {
			MongoStateView stateView = new MongoStateView(state);
			
			stateViews.add(stateView);
		}
		
		return stateViews;
	}

	@Override
	protected ColumnConfiguration convertEntityToColumns(MongoStateView row) {
		ColumnConfiguration columnConfig = new SimpleColumnConfiguration();
		
		columnConfig.setColumn(0, new SimpleColumn(Visible.YES, Sortable.YES, row.getCountryName(),
			Searchable.YES, row.getCountryName()));
		columnConfig.setColumn(1, new SimpleColumn(Visible.YES, Sortable.YES, row.getName(),
				Searchable.YES, row.getName()));
		
		return columnConfig;
	}

	@Override
	protected List<MongoState> query(JQueryDataTableParameter parameters) {
		Criteria whereCountry = Criteria.where("country.$id").is(parameters.getCountryID());
		
		return getMongoDao().query(whereCountry);
	}

	@Override
	protected JSONArray convertTableRowsToJsonArray(List<MongoStateView> tableRows) {
		JSONArray jsonArray = new JSONArray();

		for (MongoStateView row : tableRows) {
			JSONArray tableRow = new JSONArray();

			tableRow.put(row.getCountryName());
			tableRow.put("<div class='stateID' id='"+row.getStateID()+"'>"+row.getName()+"</div>");

			jsonArray.put(tableRow);
		}

		return jsonArray;
	}

}
