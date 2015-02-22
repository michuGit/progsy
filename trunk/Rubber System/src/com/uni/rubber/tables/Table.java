package com.uni.rubber.tables;

import java.io.Serializable;

public abstract class Table implements Serializable {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
