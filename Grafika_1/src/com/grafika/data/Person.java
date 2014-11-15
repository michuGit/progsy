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

public class Person implements Serializable{
	static Logger log = Logger.getLogger(Main.class.getName());

	private List<Ellipse2D> ellipse;
	private List<Rectangle2D> rectangle;
	private List<Polygon> polygon;
	private String name = null;
	private Color color;

	public Person() {
		this.ellipse = new ArrayList<Ellipse2D>();
		this.rectangle = new ArrayList<Rectangle2D>();
		this.polygon = new ArrayList<Polygon>();
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

	public void add(Object obj) {
		if (obj instanceof Ellipse2D) {
			ellipse.add((Ellipse2D) obj);
		} else if (obj instanceof Rectangle2D) {
			rectangle.add((Rectangle2D) obj);
		} else if (obj instanceof Polygon) {
			polygon.add((Polygon) obj);
		} else {
			log.error("Nie rozpoznano obiektu!");
		}

	}

	public List<Ellipse2D> getEllipseList() {
		return this.ellipse;
	}

	public List<Rectangle2D> getRectangleList() {
		return this.rectangle;
	}

	public List<Polygon> getPolygonList() {
		return this.polygon;
	}
}
