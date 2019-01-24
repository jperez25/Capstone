package com.capstone.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String first_name;
	private String last_name;
	private double weight;
	private double height;
	private int eye_colour;
	private String ssn;
	
	public  Patient() {}
	
	public Patient(String first_name, String last_name, double weight, double height, int eye_colour,
			String ssn) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.weight = weight;
		this.height = height;
		this.eye_colour = eye_colour;
		this.ssn = ssn;
	}
	
	public Patient(int id, String first_name, String last_name, double weight, double height, int eye_colour,
			String ssn) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.weight = weight;
		this.height = height;
		this.eye_colour = eye_colour;
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getEye_colour() {
		return eye_colour;
	}

	public void setEye_colour(int eye_colour) {
		this.eye_colour = eye_colour;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	

}
