package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.model.HolidayRuleDate;
import calendar.model.HolidayRuleDayOfMonth;
import calendar.model.HolidayRuleDayOfWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import calendar.rest.AddRequest;
import calendar.services.HolidayCalendarService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

@Controller
public class HolidayCalendarController {

    @Autowired
    private HolidayCalendarService service;

    @RequestMapping(Endpoints.HOME)
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = Endpoints.ADD_CALENDAR, method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    String addCalendar(AddRequest request){
        service.save(new HolidayCalendar());
        return "SUCCESS!";
    }

    @RequestMapping(value = Endpoints.ALL_CALENDARS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<HolidayCalendar> allCalendars(){
        return service.findAll();
    }

    @RequestMapping(value = Endpoints.GET_CALENDAR, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HolidayCalendar getCalendar(@PathVariable Long id) {
        return service.findById(id);
    }

}
