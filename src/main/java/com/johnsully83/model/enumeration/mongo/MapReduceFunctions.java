package com.johnsully83.model.enumeration.mongo;

public enum MapReduceFunctions {
	PRIME_CLEANING("prime/cleaning/", "map.js", "reduce.js"),
	;
	
	private static final String MASTER_FOLDER = "classpath:javascript/";
	
	private final String entityFolderName;
	
	private final String mapFunctionFileName;
	private final String reduceFunctionFileName;
	
	private MapReduceFunctions(String entityFolderName, String mapFunctionFileName, String reduceFunctionFileName) {
		this.entityFolderName = entityFolderName+"/";
		this.mapFunctionFileName = mapFunctionFileName;
		this.reduceFunctionFileName = reduceFunctionFileName;
	}
	
	public String mapFunction() {
		return MASTER_FOLDER+entityFolderName+mapFunctionFileName;
	}
	
	public String reduceFunction() {
		return MASTER_FOLDER+entityFolderName+reduceFunctionFileName;
	}

}
