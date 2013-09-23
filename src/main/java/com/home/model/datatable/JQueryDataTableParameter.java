package com.home.model.datatable;

public class JQueryDataTableParameter {

	private String sEcho;
	private String sSearch;
	private String sSearch_0;
	private String sSearch_1;
	private String sSearch_2;
	private String sSearch_3;
	private Integer iDisplayLength;
	private Integer iDisplayStart;
	private Integer iColumns;
	private Integer iSortingCols;
	private Integer iSortCol_0;
	private String sSortDir_0;
	private String sColumns;
	private Integer iTotalDisplayRecords;
	private Integer iTotalRecords;
	
	private Integer countryID;
	private Integer stateID;
	
	private Integer fromPrime;
	private Integer toPrime;
	private String findPrime;

	public JQueryDataTableParameter() {
		super();
		this.sEcho = "";
		this.sSearch = "";
		this.sSearch_0 = "";
		this.sSearch_1 = "";
		this.sSearch_2 = "";
		this.sSearch_3 = "";
		this.sSortDir_0 = "";
		this.sColumns = "";
	}
		
	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public String getsSearch_0() {
		return sSearch_0;
	}

	public void setsSearch_0(String sSearch_0) {
		this.sSearch_0 = sSearch_0;
	}

	public String getsSearch_1() {
		return sSearch_1;
	}

	public void setsSearch_1(String sSearch_1) {
		this.sSearch_1 = sSearch_1;
	}

	public String getsSearch_2() {
		return sSearch_2;
	}

	public void setsSearch_2(String sSearch_2) {
		this.sSearch_2 = sSearch_2;
	}

	public String getsSearch_3() {
		return sSearch_3;
	}

	public void setsSearch_3(String sSearch_3) {
		this.sSearch_3 = sSearch_3;
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiColumns() {
		return iColumns;
	}

	public void setiColumns(Integer iColumns) {
		this.iColumns = iColumns;
	}

	public Integer getiSortingCols() {
		return iSortingCols;
	}

	public void setiSortingCols(Integer iSortingCols) {
		this.iSortingCols = iSortingCols;
	}

	public Integer getiSortCol_0() {
		return iSortCol_0;
	}

	public void setiSortCol_0(Integer iSortCol_0) {
		this.iSortCol_0 = iSortCol_0;
	}

	public String getsSortDir_0() {
		return sSortDir_0;
	}

	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}
	
	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public Integer getFromPrime() {
		return fromPrime;
	}

	public void setFromPrime(Integer fromPrime) {
		this.fromPrime = fromPrime;
	}

	public Integer getToPrime() {
		return toPrime;
	}

	public void setToPrime(Integer toPrime) {
		this.toPrime = toPrime;
	}

	public String getFindPrime() {
		return findPrime;
	}

	public void setFindPrime(String findPrime) {
		this.findPrime = findPrime;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append("{" + NEW_LINE);
		result.append(" sEcho: " + sEcho + "," + NEW_LINE);
		result.append(" sSearch: " + sSearch + "," + NEW_LINE);
		result.append(" sSearch_0: " + sSearch_0 + "," + NEW_LINE);
		result.append(" sSearch_1: " + sSearch_1 + "," + NEW_LINE);
		result.append(" sSearch_2: " + sSearch_2 + "," + NEW_LINE);
		result.append(" sSearch_3: " + sSearch_3 + "," + NEW_LINE);
		result.append(" iDisplayLength: " + iDisplayLength + "," + NEW_LINE);
		result.append(" iDisplayStart: " + iDisplayStart + "," + NEW_LINE);
		result.append(" iColumns: " + iColumns + "," + NEW_LINE);
		result.append(" iSortingCols: " + iSortingCols + "," + NEW_LINE);
		result.append(" iSortCol_0: " + iSortCol_0 + "," + NEW_LINE);
		result.append(" sSortDir_0: " + sSortDir_0 + "," + NEW_LINE);
		result.append(" sColumns: " + sColumns + "," + NEW_LINE);
		result.append(" iTotalDisplayRecords: " + iTotalDisplayRecords + "," + NEW_LINE);
		result.append(" iTotalRecords: " + iTotalRecords + "," + NEW_LINE);
		result.append(" countryID: " + countryID + "," + NEW_LINE);
		result.append(" stateID: " + stateID + "," + NEW_LINE);
		result.append(" fromPrime: " + fromPrime + "," + NEW_LINE);
		result.append(" toPrime: " + toPrime + "," + NEW_LINE);
		result.append(" findPrime: " + findPrime + "," + NEW_LINE);
		result.append("}");

		return result.toString();
	}
	
	

}
