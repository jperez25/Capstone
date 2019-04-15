package com.capstone.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointments_per_patient")
public class AppointmentsPerPatient {


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long patient_Id;
	private long appoiment_id;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPatientId() {
    return patient_Id;
  }

  public void setPatientId(long patientId) {
    this.patient_Id = patientId;
  }


  public long getAppoiment() {
    return appoiment_id;
  }

  public void setAppoiment(long appoiment) {
    this.appoiment_id = appoiment;
  }

}
