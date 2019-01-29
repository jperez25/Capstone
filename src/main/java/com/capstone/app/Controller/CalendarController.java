package com.capstone.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capstone.app.DAO.AppoimentDAO;
import com.capstone.app.Model.Appoiment;

@Controller
public class CalendarController {
	@Autowired
	AppoimentDAO apps;
	
	
    @RequestMapping(value="/calendar", method=RequestMethod.GET) 
    public String index(Model model) {
        model.addAttribute("apps", apps.getAllApoiments() );
        return "calendar/calendar.html";
    }
}
