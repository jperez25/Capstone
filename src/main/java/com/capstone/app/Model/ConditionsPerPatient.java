package com.capstone.app.Model;

public class ConditionsPerPatient {

  private long id;
  private long patientId;
  private long condition;


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


  public long getCondition() {
    return condition;
  }

  public void setCondition(long condition) {
    this.condition = condition;
  }

}
