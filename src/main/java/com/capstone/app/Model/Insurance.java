package com.capstone.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String insurance_name;
	
	private String group_number;
	
	private String pcp;
	
	private String effective_date;
	
	private String insurance_number;
	
	public Insurance() {}
	
	public Insurance(String insurance_name, String group_number, String pcp, String effective_date,
			String insurance_number) {
		super();
		this.insurance_name = insurance_name;
		this.group_number = group_number;
		this.pcp = pcp;
		this.effective_date = effective_date;
		this.insurance_number = insurance_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsurance_name() {
		return insurance_name;
	}

	public void setInsurance_name(String insurance_name) {
		this.insurance_name = insurance_name;
	}

	public String getGroup_number() {
		return group_number;
	}

	public void setGroup_number(String group_number) {
		this.group_number = group_number;
	}

	public String getPcp() {
		return pcp;
	}

	public void setPcp(String pcp) {
		this.pcp = pcp;
	}

	public String getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	public String getInsurance_number() {
		return insurance_number;
	}

	public void setInsurance_number(String insurance_number) {
		this.insurance_number = insurance_number;
	}
	
	
	
}
