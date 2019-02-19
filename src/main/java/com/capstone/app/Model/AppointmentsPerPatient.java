package com.capstone.app.Model;


public class AppoimentsPerPatient {

  private long id;
  private long patientId;
  private long appoiment;


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


  public long getAppoiment() {
    return appoiment;
  }

  public void setAppoiment(long appoiment) {
    this.appoiment = appoiment;
  }

}
