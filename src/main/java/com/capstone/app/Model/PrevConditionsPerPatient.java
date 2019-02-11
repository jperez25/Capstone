package com.capstone.app.Model;


public class PrevConditionsPerPatient {

  private long id;
  private long patientId;
  private long prevCondition;


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


  public long getPrevCondition() {
    return prevCondition;
  }

  public void setPrevCondition(long prevCondition) {
    this.prevCondition = prevCondition;
  }

}
