package com.capstone.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.app.DAO.PatientDAO;
import com.capstone.app.Model.Patient;

@Controller
public class PatientController {
	
	@Autowired
	PatientDAO patientDAO;
	
	@RequestMapping(value = "/create_patient", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("patient", new Patient());
		
		return "patient/create_patient";
	}
	
	@RequestMapping(value = "/store_patient", method = RequestMethod.POST)
	public String store(@ModelAttribute Patient pat) {
		
		
		patientDAO.newPatient(pat);
		
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
