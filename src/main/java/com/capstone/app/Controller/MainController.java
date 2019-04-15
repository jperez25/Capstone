package com.capstone.app.Controller;


import java.security.Principal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.app.DAO.AppointmentDAO;
import com.capstone.app.DAO.AppointmetsPerPatientDAO;
import com.capstone.app.DAO.EmergencyContactDAO;
import com.capstone.app.DAO.InsuranceDAO;
import com.capstone.app.DAO.OfficeDAO;
import com.capstone.app.DAO.PatientDAO;
import com.capstone.app.DAO.UserDAO;
import com.capstone.app.Model.Appointment;
import com.capstone.app.Model.Emergency_contacts;
import com.capstone.app.Model.Insurance;
import com.capstone.app.Model.Patient;
import com.capstone.app.Utils.WebUtils;
 
@Controller
public class MainController {
	
	@Autowired
	OfficeDAO OfficeDAO;
	
	@Autowired
	PatientDAO patientDAO;
	
	@Autowired 
	InsuranceDAO insuranceDAO;
	
	@Autowired
	AppointmentDAO apps;
	
	@Autowired
	AppointmetsPerPatientDAO apptPerPatDAO;
	
	@Autowired
	EmergencyContactDAO emerContcDAO;
	
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        model.addAttribute("loggedIn",com.capstone.app.Model.User.isLoggednIn() );
        return "index";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "adminPage";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {    	 
    	
    	if(com.capstone.app.Model.User.isLoggednIn()) {
    		return "redirect:/home";
    	}
    	 
    	 model.addAttribute("offices",  OfficeDAO.getAllOficces());
    	 
        return "login";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
    	
    	List<Appointment> appo = apps.getAllTodaysAppointments();
    	
    	List<Patient> pats = new ArrayList<Patient>();
    	
    	List<Integer> ages = new ArrayList<Integer>(); 
    		
    	for(Appointment appt : appo){
    		//Getting all patients that have appts for the day
    		pats.add(patientDAO.getPatientByID(Integer.toString(apps.getPatientIdByAppt(appt.getId()).getPatient_id())));
    	}
    	    		
    	for(Patient pat : pats) {
    		ages.add(Patient.calculateAge(pat.getDOB()));
    	}
    	
    	model.addAttribute("patients", pats);
    	model.addAttribute("ages", ages);
    	model.addAttribute("apps", appo);
 
        return "home";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // (1) (en)
        // After user login successfully.
        // (vi)
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        return "userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
    
    @RequestMapping(value = "/get_patients_by_id", method = RequestMethod.GET)
    public String showPatienttList(Model model, @RequestParam String last_name) {
    	
    	model.addAttribute("patients", patientDAO.getPatientsByID(last_name) );
    	
        return "patient\\patients :: patients";
    }
    
    @RequestMapping(value = "/get_patients_by_last_name", method = RequestMethod.GET)
    public String showPatientsList(Model model, @RequestParam String last_name) {
    	
    	model.addAttribute("patients", patientDAO.getPatientsByName(last_name) );
    	
        return "patient\\patients :: patients";
    }
    
    @RequestMapping(value = "/get_patient", method = RequestMethod.GET)
    public String patient_info(Model model, @RequestParam String patient_id) {
    	
    	Patient pat =  patientDAO.getPatientById(patient_id);
    	
    	List<Emergency_contacts> contacts = emerContcDAO.get_emer_contact_by_pat_id(Integer.valueOf(patient_id) );
    	
    	Insurance pat_insurance = insuranceDAO.getInsuranceById(pat.getInsurance());
    	
    	int years = Patient.calculateAge(pat.getDOB());
    	
    	
    	model.addAttribute("patient", pat );
    	model.addAttribute("age", years);
    	model.addAttribute("pat_insurance", pat_insurance);
    	model.addAttribute("contacts",contacts);
    	
        return "patient\\patient :: patient_info";
    }
 
}
