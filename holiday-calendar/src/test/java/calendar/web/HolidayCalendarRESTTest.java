package calendar.web;

import calendar.factories.HolidayCalendarTestFactory;
import calendar.model.HolidayCalendar;
import calendar.repositories.HolidayCalendarRepository;
import calendar.services.HolidayCalendarService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class HolidayCalendarRESTTest extends RESTTestBase {

    private HolidayCalendarTestFactory factory = new HolidayCalendarTestFactory();

    @MockBean
    private HolidayCalendarService holidayCalendarService;

    @MockBean
    private HolidayCalendarRepository holidayCalendarRepository;

    @Before
    public void setUp() {
        Mockito.reset(holidayCalendarService);
        Mockito.reset(holidayCalendarRepository);
    }

    @Test
    public void whenAClientRequestsAllCalendars() throws Exception {
        given(holidayCalendarService.findByNameContaining(""))
                .willReturn(Arrays.asList(
                    new HolidayCalendar("Argentina"),
                    new HolidayCalendar("Uruguay")
        ));

        mockClient.perform(get("/calendarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name").value("Argentina"))
                .andExpect(jsonPath("$[1].name").value("Uruguay"));
    }

    @Test
    public void whenAClientRequestsAllCalendarsWhoseNameMatchsAKeyWord() throws Exception {
        given(holidayCalendarService.findByNameContaining("GEN"))
                .willReturn(Arrays.asList(
                    new HolidayCalendar("Argentina")
        ));

        mockClient.perform(get("/calendarios?nombre=GEN"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name").value("Argentina"));
    }

    @Test
    public void whenAClientRequestsACalendarByItsID() throws Exception {
        given(holidayCalendarService.findById(2L))
                .willReturn(new HolidayCalendar("Uruguay")
        );

        mockClient.perform(get("/calendarios/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name").value("Uruguay"));
    }

    @Test
    public void whenAClientPostsACalendarWithoutHolidayRulesItIsSavedInTheDB() throws Exception{
        HolidayCalendar newHolidayCalendar = new HolidayCalendar("Chile");

        mockClient.perform(post("/calendarios")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(objectMapper.writeValueAsString(newHolidayCalendar)))
                .andExpect(status().isOk())
                .andExpect(content().string("SUCCESS!"));
    }

    @Test
    public void whenAClientPostsACalendarWithHolidayRulesItIsSavedInTheDB() throws Exception{
        HolidayCalendar newHolidayCalendar = new HolidayCalendar("Chile");
        newHolidayCalendar.addHolidayRule(factory.defaultHolidayRuleDayOfWeek());
        newHolidayCalendar.addHolidayRule(factory.defaultHolidayRuleDayOfMonth());
        newHolidayCalendar.addHolidayRule(factory.defaultHolidayRuleDate());
        newHolidayCalendar.addHolidayRule(factory.defaultHolidayRuleWithInterval());

        mockClient.perform(post("/calendarios")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(objectMapper.writeValueAsString(newHolidayCalendar)))
                .andExpect(status().isOk())
                .andExpect(content().string("SUCCESS!"));
    }

}
