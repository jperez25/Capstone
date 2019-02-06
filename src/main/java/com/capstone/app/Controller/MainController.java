package com.capstone.app.Controller;


import java.security.Principal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.app.DAO.OfficeDAO;
import com.capstone.app.DAO.PatientDAO;
import com.capstone.app.DAO.UserDAO;
import com.capstone.app.Model.Patient;
import com.capstone.app.Utils.WebUtils;
 
@Controller
public class MainController {
	@Autowired
	OfficeDAO OfficeDAO;
	
	@Autowired
	PatientDAO patientDAO;
	
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
    
    @RequestMapping(value = "/get_patients", method = RequestMethod.GET)
    public String showGuestList(Model model, @RequestParam String last_name) {
    	
    	model.addAttribute("patients", patientDAO.getPatientsByName(last_name) );
    	
        return "patient\\patients :: patients";
    }
    
    @RequestMapping(value = "/get_patient", method = RequestMethod.GET)
    public String patient_info(Model model, @RequestParam String patient_id) {
    	
    	Patient pat =  patientDAO.getPatientById(patient_id);
    	
    	//get patients DOB
    	String[] DOBArray = pat.getDOB().split("-");
    	int day = Integer.parseInt(DOBArray[2]); 
    	int month = Integer.parseInt(DOBArray[1]); 
    	int year = Integer.parseInt(DOBArray[0]); 
    	
    	// use for age-calculation: LocalDate.now()
    	String[] todaysDay = LocalDate.now().toString().split("-"); 
    	int today = Integer.parseInt(todaysDay[2]);
    	int currentMonth = Integer.parseInt(todaysDay[1]);
    	int currentYear = Integer.parseInt(todaysDay[0]);
    	
    	//calculate age
    	LocalDate start = LocalDate.of(year,month,day);
    	LocalDate end = LocalDate.of(currentYear, currentMonth, today); 
    	long years = ChronoUnit.YEARS.between(start, end);
    	
    	
    	model.addAttribute("patient", pat );
    	model.addAttribute("age", years);
    	
        return "patient\\patient :: patient_info";
    }
 
}
