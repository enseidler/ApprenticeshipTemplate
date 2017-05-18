package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.model.HolidayRuleDayOfMonth;
import calendar.services.HolidayCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.MonthDay;
import java.util.List;

@Controller
public class HolidayCalendarController {

    @Autowired
    private HolidayCalendarService holidayCalendarService;

    @RequestMapping(Endpoints.HOME)
    public String home(Model model) {
        return "index";
    }


    @RequestMapping(value = Endpoints.ALL_CALENDARS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<HolidayCalendar> allCalendars(@RequestParam(value = "nombre", required=false, defaultValue = "") String aName) {
        return holidayCalendarService.findByNameContaining(aName);
    }

    @RequestMapping(value = Endpoints.ADD_CALENDAR, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String addCalendar(@RequestBody HolidayCalendar newHolidayCalendar) {
        holidayCalendarService.save(newHolidayCalendar);
        return "SUCCESS!";
    }

    @RequestMapping(value = Endpoints.GET_CALENDAR, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HolidayCalendar getCalendar(@PathVariable Long id) {
        return holidayCalendarService.findById(id);
    }

}