package com.uni.rubber.production;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uni.rubber.database.DatabaseConnector;
import com.uni.rubber.reports.Report;

public abstract class Product implements Report, DatabaseConnector {
	protected String name;
	protected String Recipe;
	protected Shift shift;
	protected Date date;
	protected Machine machine;
//	protected User contractor;
//	protected User assistant;
	protected List<String> parametersName;
	protected List<Object> parametersValue;

	public Product() {
		this.parametersName = new ArrayList<String>();
		this.parametersValue = new ArrayList<Object>();
	}

	protected void addParameter(String label, Object value) {
		this.parametersName.add(label);
		this.parametersValue.add(value);
	}
}
