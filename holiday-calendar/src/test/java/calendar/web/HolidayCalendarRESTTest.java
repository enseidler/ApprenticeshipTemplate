package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.repositories.HolidayCalendarRepository;
import calendar.services.HolidayCalendarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class HolidayCalendarRESTTest extends RESTTestBase {

    @Autowired
    private HolidayCalendarService holidayCalendarService;

    @Before
    public void setUp() {
        holidayCalendarService.save(new HolidayCalendar());
        holidayCalendarService.save(new HolidayCalendar());
    }

    @Test
    public void whenAClientRequestsAllCalendars() throws Exception {
        mockClient.perform(get(Endpoints.ALL_CALENDARS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json("[{id: 1, holidayRules: []},{id: 2, holidayRules: []}]"));
    }

}
