package com.home.model.enumeration.geoplanet;

public enum GeoPlanetPlaceType {
	HISTORICALSTATE("Historical State",26),
	LOCALADMINISTRATIVEAREA("Local Administrative Area",10),
	ISLAND("Island", 13),
	CONTINENT("Continent", 29),
	ZONE("Zone", 25),
	MISCELLANEOUS("Miscellaneous", 17),
	SUPERNAME("Supername", 19),
	LANDFEATURE("Land Feature", 16),
	OCEAN("Ocean",37),
	DRAINAGE("Drainage",15),
	POSTALCODE("Postal Code",11),
	HISTORICALCOUNTY("Historical County",27),
	COLLOQUIAL("Colloquial",24),
	COUNTRY("Country",12),
	TIMEZONE("Time Zone",31),
	SEA("Seas",38),
	ESTATE("Estate",33),
	HISTORICALTOWN("Historical Town",35),
	COUNTY("County",9),
	AIRPORT("Airport",14),
	STATE("State",8),
	TOWN("Town",7),
	SUBURB("Suburb",22),
	UNDEFINED("Undefined",0),
	POINTOFINTEREST("Point of Interest",20)
	;
	
	private String name;
	private Integer placeTypeID;
	
	private GeoPlanetPlaceType(String name, Integer placeTypeID) {
		this.name=name;
		this.placeTypeID=placeTypeID;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPlaceTypeID() {
		return placeTypeID;
	}
	
}
