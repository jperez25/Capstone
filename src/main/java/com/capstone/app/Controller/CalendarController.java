package com.capstone.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class CalendarController {
    @RequestMapping(value="/calendar", method=RequestMethod.GET) 
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("calendar.html");
        return modelAndView;
    }
}
