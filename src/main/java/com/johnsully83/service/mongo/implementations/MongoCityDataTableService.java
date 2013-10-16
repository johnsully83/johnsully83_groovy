package com.johnsully83.service.mongo.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.MongoDao;
import com.johnsully83.model.cloud.mongo.MongoCity;
import com.johnsully83.model.datatable.JQueryDataTableParameter;
import com.johnsully83.model.datatable.structure.ColumnConfiguration;
import com.johnsully83.model.datatable.structure.enums.Searchable;
import com.johnsully83.model.datatable.structure.enums.Sortable;
import com.johnsully83.model.datatable.structure.enums.Visible;
import com.johnsully83.model.datatable.structure.simple.SimpleColumn;
import com.johnsully83.model.datatable.structure.simple.SimpleColumnConfiguration;
import com.johnsully83.model.datatable.view.MongoCityView;
import com.johnsully83.service.mongo.AbstractMongoDataTableService;

@Service("mongoCityDataTableService")
public class MongoCityDataTableService extends AbstractMongoDataTableService<MongoCity, Integer, MongoCityView> {
	
	@Autowired
	public MongoCityDataTableService(@Qualifier("cityMongoDao") MongoDao<MongoCity, Integer> cityMongoDao) {
		super(cityMongoDao);
	}

	@Override
	protected List<MongoCityView> convertNonEmptyDtosToViews(List<MongoCity> records) {
		List<MongoCityView> mongoCityViews = new ArrayList<MongoCityView>();
		
		for(MongoCity mongoCity : records) {
			mongoCityViews.add(new MongoCityView(mongoCity));
		}
		
		return mongoCityViews;
	}

	@Override
	protected ColumnConfiguration convertEntityToColumns(MongoCityView row) {
		ColumnConfiguration columnConfig = new SimpleColumnConfiguration();

		
		columnConfig.setColumn(0, new SimpleColumn(Visible.YES, Sortable.YES, row.getCountryName(),
			Searchable.YES, row.getCountryName()));
		columnConfig.setColumn(1, new SimpleColumn(Visible.YES, Sortable.YES, row.getStateName(),
				Searchable.YES, row.getStateName()));
		columnConfig.setColumn(2, new SimpleColumn(Visible.YES, Sortable.YES, row.getName(),
			Searchable.YES, row.getName()));
		
		return columnConfig;
	}

	@Override
	protected List<MongoCity> query(JQueryDataTableParameter parameters) {
		Criteria whereState = Criteria.where("state.$id").is(parameters.getStateID());
		
		return getMongoDao().query(whereState);
	}

}
