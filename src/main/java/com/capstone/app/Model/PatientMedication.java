package com.capstone.app.Model;

public class PatientMedication {

  private long id;
  private long patientId;
  private long medicationId;
  private long current;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPatientId() {
    return patientId;
  }

  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }


  public long getMedicationId() {
    return medicationId;
  }

  public void setMedicationId(long medicationId) {
    this.medicationId = medicationId;
  }


  public long getCurrent() {
    return current;
  }

  public void setCurrent(long current) {
    this.current = current;
  }

}
