package io.evently.Entity;

import java.util.Date;

// represents a list element in the list view
public class Model {
	
	String busName;
	Date stopDate;
	
	public String getBusName() {
		return busName;
	}
	public Date getStopDate() {
		return stopDate;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	
}
