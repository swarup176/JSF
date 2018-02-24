package com.cts;

import javax.faces.context.FacesContext;

public class TableData1 {
	private  String fetchName ;
	
	public  String getFetchName() {
		FacesContext context = FacesContext.getCurrentInstance();
		TableData table = (TableData)context.getExternalContext().getSessionMap().get("tableData");
		Name name  = table.names[0];
		fetchName = name.getFirst();
		System.out.println(fetchName);
		return fetchName;
	}

	public  void setFetchName(String fetchName) {
		this.fetchName = fetchName;
	}

	

}
