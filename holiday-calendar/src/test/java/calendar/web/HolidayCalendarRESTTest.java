package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.services.HolidayCalendarService;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
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

    private Gson gson = new Gson();

    private String argentinaCalendar;

    private String uruguayCalendar;

    @Before
    public void setUp() {
        holidayCalendarService.save(new HolidayCalendar("Argentina"));
        holidayCalendarService.save(new HolidayCalendar("Uruguay"));

        argentinaCalendar = gson.toJson(holidayCalendarService.findById(1l));
        uruguayCalendar = gson.toJson(holidayCalendarService.findById(2l));
    }

    @Test
    public void whenAClientRequestsAllCalendars() throws Exception {
        mockClient.perform(get("/calendarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(
                        "[" + argentinaCalendar + "," + uruguayCalendar + "]", true));
    }

    @Test
    public void whenAClientRequestsAllCalendarsWhoseNameMatchsAKeyWord() throws Exception {
        mockClient.perform(get("/calendarios?nombre=GEN"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(
                        "[" + argentinaCalendar + "]", true));
    }

    @Test
    public void whenAClientRequestsACalendarByItsID() throws Exception {
        mockClient.perform(get("/calendarios/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(uruguayCalendar, true));
    }

}
