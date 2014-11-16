package com.grafika.data;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.grafika.starter.Main;

public class Person implements Serializable {
	static Logger log = Logger.getLogger(Main.class.getName());

	public boolean visible = true;
	private boolean cutable = false;
	private Object figure;
	private String name = null;
	private Color color;

	public Person() {
		this.figure = new Object();
	}

	public void setColor(Color c) {
		this.color = c;
	}

	public Color getColor() {
		return this.color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void addFigure(Object obj) {
		this.figure = obj;
	}

	public Object getFigure() {
		return this.figure;
	}
}
