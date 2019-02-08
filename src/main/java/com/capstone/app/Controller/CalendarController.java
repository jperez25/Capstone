package com.capstone.app.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

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
			TimeZone tz = TimeZone.getTimeZone("UTC");
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.US);
			sdf.setTimeZone(tz);
			Date day = null;
			Date endtime = null;
			try {
				int endhour = app.getHour()+app.getDuration();
				System.out.println(app.getDate());
				System.out.println(app.getHour());
				day = sdf.parse(app.getDate()+"T"+Integer.toString(app.getHour()-8)+":00-0800");
				endtime = sdf.parse(app.getDate()+"T"+Integer.toString(endhour-8)+":00-0800");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ev.setTitle(app.getDescription());
			ev.setStart(day);
			ev.setEnd(endtime);
			ev.setDescription(String.valueOf(app.getId()));
			ev.setId(app.getId());
			events.add(ev);
		}
        
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }
    @RequestMapping(value="/calendar/add_event", method=RequestMethod.GET) 
    public String add_event(Model model) {
        Appointment app = new Appointment();
        model.addAttribute("appointment",app);
        return "calendar/add :: add_event";
    }
    
    @RequestMapping(value="/get_app_by_id", method=RequestMethod.GET) 
    public String getAppById(Model model, @RequestParam String app_id) {
        
        model.addAttribute("app", apps.getApoimentsById(Integer.parseInt(app_id)));
        
        return "calendar/AppoinmentModal :: modal";
    }
    
    @RequestMapping(value="/calendar/update_event", method=RequestMethod.POST) 
    public String update_event(Model model, @RequestParam("description") String description, @RequestParam("start") int start, @RequestParam("duration") String duration, @RequestParam("date") String date, @RequestParam("id") int id) {
        model.addAttribute("apps", apps.getAllApoiments() );
        apps.updateAppointment(id, date, start, duration, description);
        return "redirect:/calendar";
    }
    
    @RequestMapping(value="/calendar/delete_event", method=RequestMethod.POST) 
    public String delete_event(Model model, @RequestParam("id") int id) {
        model.addAttribute("apps", apps.getAllApoiments() );
        apps.deleteAppointment(id);
        return "redirect:/calendar";
    }
    
    @RequestMapping(value="/calendar/store_event", method=RequestMethod.POST) 
    public String store(Model model, @RequestParam("patient") String patient, @RequestParam("doctor") String doctor, @RequestParam("start") int start, @RequestParam("duration") String duration, @RequestParam("date") String date) {
        model.addAttribute("apps", apps.getAllApoiments() );
        System.out.println(date);
        System.out.println(start);
        System.out.println(duration);
        apps.storeAppointment(date, start, duration,patient,doctor);
        return "redirect:/calendar";
    } 
    
    

}
