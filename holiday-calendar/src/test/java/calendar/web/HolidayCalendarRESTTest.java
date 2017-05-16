package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.services.HolidayCalendarService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class HolidayCalendarRESTTest extends RESTTestBase {

    @Autowired
    private HolidayCalendarService holidayCalendarService;

    @Before
    public void setUp() {
        holidayCalendarService.save(new HolidayCalendar("nombre"));
        holidayCalendarService.save(new HolidayCalendar("nombre"));
    }

    @Test
    public void whenAClientRequestsAllCalendars() throws Exception {
        mockClient.perform(get(Endpoints.ALL_CALENDARS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json("[{id: 1, holidayRules: []},{id: 2, holidayRules: []}]"));
    }

}
