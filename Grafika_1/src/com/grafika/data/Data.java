package com.grafika.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.grafika.starter.Main;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(Main.class.getName());
	
	private List<Person> person;

	public Data() {
		this.person = new ArrayList<Person>();
	}
	
	public void add(Person p){
		this.person.add(p);
	}
	
	public List<Person> get(){
		return this.person;
	}

}
