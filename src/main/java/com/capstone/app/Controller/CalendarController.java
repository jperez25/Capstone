package com.capstone.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capstone.app.DAO.AppointmentDAO;
import com.capstone.app.Model.Appointment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class CalendarController {
	@Autowired
	AppointmentDAO apps;
	
	
    @RequestMapping(value="/calendar", method=RequestMethod.GET) 
    public String index(Model model) {
        model.addAttribute("apps", apps.getAllApoiments() );
        return "calendar/calendar.html";
    }
    
    @RequestMapping(value="/get_apps", method=RequestMethod.GET) 
    public ResponseEntity<List<Appointment>> getApps(Model model) {
        //model.addAttribute("apps", apps.getAllApoiments() );
        
        
        //new ResponseEntity<List<Appointment>>(apps.getAllApoiments(), HttpStatus.OK);
        
        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        //String json = "";
        /*try {
			json = ow.writeValueAsString(apps.getAllApoiments());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        return new ResponseEntity<List<Appointment>>(apps.getAllApoiments(), HttpStatus.OK);
    }
}
