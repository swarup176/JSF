package com.roseindia;

import java.util.*;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
public class LocaleBean{
	
	private String locale;
	private Map<String,Object> countryMap;

	public LocaleBean(){
		countryMap = new LinkedHashMap<String,Object>();
		countryMap.put("English", new Locale("en"));
		countryMap.put("French", new Locale("fr","FR"));
	}
	

	public Map<String, Object> getCountries() {
		return countryMap;
	}
	
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void localeChanged(ValueChangeEvent e){
		
		String localeStr = e.getNewValue().toString();		
		
        for (Map.Entry<String, Object> entry : countryMap.entrySet()) {        
        	if(entry.getValue().toString().equals(localeStr)){
				Locale locale = (Locale)entry.getValue();
        		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);        		
        	}
        }
	}
}