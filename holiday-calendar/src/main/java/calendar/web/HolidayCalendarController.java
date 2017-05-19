package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.model.HolidayRule;
import calendar.model.utils.DateInterval;
import calendar.services.HolidayCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

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
    public HolidayCalendar addCalendar(@RequestBody HolidayCalendar newHolidayCalendar) {
        return holidayCalendarService.save(newHolidayCalendar);
    }

    @RequestMapping(value = Endpoints.GET_CALENDAR, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HolidayCalendar getCalendar(@PathVariable Long id) {
        return holidayCalendarService.findById(id);
    }

    @RequestMapping(value = Endpoints.UPDATE_CALENDAR, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HolidayCalendar updateCalendar(@PathVariable Long id, @RequestBody HolidayCalendar newHolidayCalendar) {
        holidayCalendarService.update(id, newHolidayCalendar);
        return holidayCalendarService.findById(id);
    }

    @RequestMapping(value = Endpoints.HOLIDAYS_DURING, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<LocalDate> getHolidayDatesDuring(@PathVariable Long id, @RequestParam(value = "desde", required=false) String start, @RequestParam(value = "hasta", required=false) String end) {
        HolidayCalendar holidayCalendar = holidayCalendarService.findById(id);

        String firstDayOfYear = LocalDate.now().with(firstDayOfYear()).toString();
        String lastDayOfYear = LocalDate.now().with(lastDayOfYear()).toString();

        Optional<String> startDate = Optional.ofNullable(start);
        Optional<String> endDate = Optional.ofNullable(end);

        DateInterval interval = DateInterval.fromDateToDate(
                LocalDate.parse(startDate.orElse(firstDayOfYear)),
                LocalDate.parse(endDate.orElse(lastDayOfYear))
        );

        return holidayCalendar.holidayDatesBetween(interval);
    }

    @RequestMapping(value = Endpoints.ADD_HOLIDAY_RULE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HolidayCalendar addHolidayRule(@PathVariable Long id, @RequestBody HolidayRule newHolidayRule) {
        return holidayCalendarService.addHolidayRuleToCalendar(id, newHolidayRule);
    }

}
