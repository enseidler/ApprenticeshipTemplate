package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.services.HolidayCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = Endpoints.AT_CALENDAR, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String updateCalendar(@PathVariable Long id, @RequestBody HolidayCalendar newHolidayCalendar) {
        holidayCalendarService.update(id, newHolidayCalendar);
        return "SUCCESS!";
    }

    @RequestMapping(value = Endpoints.AT_CALENDAR, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HolidayCalendar getCalendar(@PathVariable Long id) {
        return holidayCalendarService.findById(id);
    }

}
