package com.capstone.app.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Emergency_contacts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int patient_id;
	private String name;
	private String relationship;
	private String address;
	private String mobile;
	
	public Emergency_contacts() {}
	
	public Emergency_contacts(int patient_id, String name, String relationship, String address, String mobile) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.relationship = relationship;
		this.address = address;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}
