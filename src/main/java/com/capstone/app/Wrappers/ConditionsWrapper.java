package com.capstone.app.Wrappers;

import java.util.ArrayList;
import java.util.List;

import com.capstone.app.Model.Conditions;

public class ConditionsWrapper {
	private List<Conditions> conditionsWrapper;
	
	public ConditionsWrapper() {
		this.conditionsWrapper = new ArrayList<>();
	}

	public List<Conditions> getConditionsWrapper() {
		return conditionsWrapper;
	}
	
	public void setConditionsWrapper(ArrayList<Conditions> conditionsWrapper) {
		this.conditionsWrapper = conditionsWrapper;
	}
	
	public void addCondition(Conditions condition ) {
		this.conditionsWrapper.add(condition);
	}
	
	public List<Conditions> getConditionsList() {
		return conditionsWrapper;
	}
}
