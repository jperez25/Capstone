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
	private int gender;
	private int eye_colour;
	private String ssn;
	private String DOB;
	private String phone_number;
	private long insurance;
	private String address;
	private int marital_status;
	
	public  Patient() {}

	public Patient(String first_name, String last_name, double weight, double height, int gender, int eye_colour,
			String ssn, String dOB, String phone_number, long insurance, String address, int marital_status) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.eye_colour = eye_colour;
		this.ssn = ssn;
		DOB = dOB;
		this.phone_number = phone_number;
		this.insurance = insurance;
		this.address = address;
		this.marital_status = marital_status;
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

	public String getDOB() {
		return this.DOB;
	}

	public void setDOB(String dOB) {
		this.DOB = dOB;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(int marital_status) {
		this.marital_status = marital_status;
	}

	public void setInsurance(long insurance) {
		this.insurance = insurance;
	}

	public long getInsurance() {
		return insurance;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	

}
