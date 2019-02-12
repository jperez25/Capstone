package com.capstone.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.app.DAO.ConditionsDAO;
import com.capstone.app.DAO.InsuranceDAO;
import com.capstone.app.DAO.PatientDAO;
import com.capstone.app.Model.Conditions;
import com.capstone.app.Model.Insurance;
import com.capstone.app.Model.Patient;
import com.capstone.app.Wrappers.ConditionsWrapper;

@Controller
public class ConditionsController {
	
	@Autowired
	ConditionsDAO conditionsDAO;
	

	public String create(Model model) {
		
		
		return "";
	}
	
	
	public String store() {
		
		
		return "";
	}
	
	@RequestMapping(value = "/add_conditions", method = RequestMethod.GET)
	public String show(Model model, @RequestParam(name="conditions") ConditionsWrapper conditions) {
		
		System.out.println(conditions.getConditionsList().size());
		conditions.addCondition(new Conditions());
		
		model.addAttribute("conditions", conditions);
		return "patient/patient_form :: medical_history";
	}
	
	public String edit() {
		
		return "";
	}
	
	public String update() {
		
		return "";
	}
	
	public String destroy() {
		
		return "";
	}
	

}
