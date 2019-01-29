package com.capstone.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appoiment")
public class Appoiment {


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String date;
    private int hour;
    private int duration;
    private String description; 
    private String attendance;
    private String diagnostics;
    
    public Appoiment() {}
    
    public Appoiment(String date, int hour, int duration, String description, String attendance, String diagnostics) {
		super();
		this.date = date;
		this.hour = hour;
		this.duration = duration;
		this.description = description;
		this.attendance = attendance;
		this.diagnostics = diagnostics;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(String diagnostics) {
		this.diagnostics = diagnostics;
	}
    
    
    

}
