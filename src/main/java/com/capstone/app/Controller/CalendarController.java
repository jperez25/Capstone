package com.capstone.app.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.app.DAO.AppointmentDAO;
import com.capstone.app.Model.Appointment;
import com.capstone.app.Model.Event;
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
    public ResponseEntity<List<Event>> getApps(Model model) {
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
    	List<Appointment> appo = apps.getAllApoiments();
    	
    	List<Event> events = new ArrayList<Event>();
    	
    	for (Appointment app : appo) {
			Event ev = new Event();	
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

			Date day = null;
			Date endtime = null;
			try {
				int endhour = app.getHour()+app.getDuration();
				day = sdf.parse(app.getDate()+" "+app.getHour()+":00:00");
				endtime = sdf.parse(app.getDate()+" "+endhour+":00:00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ev.setTitle(app.getDescription());
			ev.setStart(day);
			ev.setEnd(endtime);
			ev.setDescription(String.valueOf(app.getId()));
			events.add(ev);
			
		}
        
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }
    
    @RequestMapping(value="/get_app_by_id", method=RequestMethod.GET) 
    public String getAppById(Model model, @RequestParam String app_id) {
    	
    	model.addAttribute("app", apps.getApoimentsById(Integer.parseInt(app_id)));
    	
    	return "calendar/AppoinmentModal :: modal";
    }
}
