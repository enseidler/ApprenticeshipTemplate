package calendar.web;

import calendar.factories.HolidayCalendarTestFactory;
import calendar.model.HolidayCalendar;
import calendar.model.HolidayRuleDate;
import calendar.model.HolidayRuleDayOfMonth;
import calendar.model.HolidayRuleDayOfWeek;
import calendar.services.HolidayCalendarService;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class HolidayCalendarRESTTest extends RESTTestBase {

    private HolidayCalendarTestFactory factory = new HolidayCalendarTestFactory();

    @Autowired
    private HolidayCalendarService holidayCalendarService;

    @After
    public void setUp() {
        holidayCalendarService.clear();
    }

    @Test
    public void whenAClientRequestsAllCalendars() throws Exception {
        holidayCalendarService.save(new HolidayCalendar("Argentina"));
        holidayCalendarService.save(new HolidayCalendar("Uruguay"));

        mockClient.perform(get("/calendarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name").value("Argentina"))
                .andExpect(jsonPath("$[1].name").value("Uruguay"));
    }

    @Test
    public void whenAClientRequestsAllCalendarsWhoseNameMatchsAKeyWord() throws Exception {
        holidayCalendarService.save(new HolidayCalendar("Uruguay"));
        holidayCalendarService.save(new HolidayCalendar("Argentina"));

        mockClient.perform(get("/calendarios?nombre=GEN"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name").value("Argentina"));
    }

    @Test
    public void whenAClientRequestsACalendarByItsID() throws Exception {
        Long id = holidayCalendarService.save(new HolidayCalendar("Uruguay")).getId();

        mockClient.perform(get("/calendarios/" + id))
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
                .andExpect(jsonPath("$.name").value("Chile"))
                .andExpect(jsonPath("$.holidayRules").isEmpty());
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
                .andExpect(jsonPath("$.name").value("Chile"))
                .andExpect(jsonPath("$.holidayRules.size()").value(4));
    }

    @Test
    public void whenAClientPutsACalendarWithHolidayRulesItReplacesTheHolidayRules() throws Exception{
        Long id = holidayCalendarService.save(new HolidayCalendar("Uruguay")).getId();
        HolidayCalendar newHolidayCalendar = holidayCalendarService.findById(id);
        newHolidayCalendar.addHolidayRule(factory.defaultHolidayRuleDayOfWeek());

        mockClient.perform(put("/calendarios/" + id)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(newHolidayCalendar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.holidayRules[0]").exists());
    }

    @Test
    public void whenAClientRequestsAllHolidayDatesForACalendarBetweenTwoDates() throws Exception{
        HolidayCalendar holidayCalendar = new HolidayCalendar("Argentina");
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(DayOfWeek.SUNDAY));
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfMonth(MonthDay.of(1,5)));
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        mockClient.perform(get("/calendarios/" + id + "/feriados?desde=2016-01-01&hasta=2016-01-05"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0]").value("2016-01-03"))
                .andExpect(jsonPath("$[1]").value("2016-01-05"));
    }

    @Test
    public void whenAClientRequestsAllHolidayDatesForACalendarWithoutSpecificDates() throws Exception{
        HolidayCalendar holidayCalendar = new HolidayCalendar("Argentina");
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfMonth(MonthDay.of(1,5)));
        holidayCalendar.addHolidayRule(new HolidayRuleDate(LocalDate.of(2017, 10, 16)));
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        mockClient.perform(get("/calendarios/" + id + "/feriados"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0]").value("2017-01-05"))
                .andExpect(jsonPath("$[1]").value("2017-10-16"));
    }

    @Test
    public void whenAClientPostsAHolidayRuleDayOfWeekForAHolidayCalendar() throws Exception{
        HolidayCalendar holidayCalendar = new HolidayCalendar("Argentina");
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        mockClient.perform(post("/calendarios/" + id + "/reglas_de_feriado")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(factory.defaultHolidayRuleDayOfWeek())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Argentina"))
                .andExpect(jsonPath("$.holidayRules[0]").exists());
    }

    @Test
    public void whenAClientPostsAHolidayRuleDayOfMonthForAHolidayCalendar() throws Exception{
        HolidayCalendar holidayCalendar = new HolidayCalendar("Argentina");
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        mockClient.perform(post("/calendarios/" + id + "/reglas_de_feriado")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(factory.defaultHolidayRuleDayOfMonth())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Argentina"))
                .andExpect(jsonPath("$.holidayRules[0]").exists());
    }

    @Test
    public void whenAClientPostsAHolidayRuleDateForAHolidayCalendar() throws Exception{
        HolidayCalendar holidayCalendar = new HolidayCalendar("Argentina");
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        mockClient.perform(post("/calendarios/" + id + "/reglas_de_feriado")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(factory.defaultHolidayRuleDate())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Argentina"))
                .andExpect(jsonPath("$.holidayRules[0]").exists());
    }

    @Test
    public void whenAClientPostsAHolidayRuleWithIntervalForAHolidayCalendar() throws Exception{
        HolidayCalendar holidayCalendar = new HolidayCalendar("Argentina");
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        mockClient.perform(post("/calendarios/" + id + "/reglas_de_feriado")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(factory.defaultHolidayRuleWithInterval())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Argentina"))
                .andExpect(jsonPath("$.holidayRules[0]").exists());
    }

}
