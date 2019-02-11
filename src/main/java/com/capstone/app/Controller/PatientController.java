package com.capstone.app.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.capstone.app.Model.Office;
import com.capstone.app.Model.Patient;

@Controller
public class PatientController {
	
	@Autowired
	PatientDAO patientDAO;
	
	@Autowired
	InsuranceDAO insuranceDAO;
	
	@Autowired
	ConditionsDAO conditionsDAO;
	
	@RequestMapping(value = "/create_patient", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("patient", new Patient());
		
		model.addAttribute("insurance", new Insurance());
		
		List<Conditions> conditions = new ArrayList<Conditions>(10);
		
		for (Conditions condition : conditions) {
			condition = new Conditions();
		}
		
		model.addAttribute("conditions", conditions);
		
		return "patient/create_patient";
	}
	
	@RequestMapping(value = "/store_patient", method = RequestMethod.POST)
	public String store(@ModelAttribute Patient pat, @ModelAttribute Insurance insurance, @ModelAttribute List<Conditions> conditions) {
		
		for (Conditions condition : conditions) {
			conditionsDAO.newCondition(condition);
		}
		//insuranceDAO.newInsurance(insurance);
		//patientDAO.newPatient(pat);
		
		return "redirect:/home";
	}
	
	public String show() {
		
		return "";
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
