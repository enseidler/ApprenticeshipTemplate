package calendar.persistence;

import calendar.model.*;
import calendar.model.utils.DateInterval;
import calendar.services.HolidayCalendarService;
import net.sf.cglib.core.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class PersistenceHolidayCalendarTest {

    @Autowired
    private HolidayCalendarService holidayCalendarService;

    @Test
    public void persistingAHolidayCalendarWithAHolidayRuleDayOfWeek() {
        HolidayCalendar holidayCalendar = new HolidayCalendar("nombre");
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(DayOfWeek.FRIDAY));

        LocalDate aFriday = LocalDate.of(2017, 5, 12);
        LocalDate aSaturday = LocalDate.of(2017, 5, 13);

        Long id = holidayCalendarService.save(holidayCalendar).getId();
        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findById(id);

        assertTrue(persistedHolidayCalendar.isHoliday(aFriday));
        assertFalse(persistedHolidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void persistingAHolidayCalendarWithAHolidayRuleDayOfMonth() {
        HolidayCalendar holidayCalendar = new HolidayCalendar("nombre");
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfMonth(MonthDay.of(5, 1)));

        LocalDate aMayFirst = LocalDate.of(2017, 5, 1);
        LocalDate aMaySeventh = LocalDate.of(2017, 5, 7);

        Long id = holidayCalendarService.save(holidayCalendar).getId();
        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findById(id);

        assertTrue(persistedHolidayCalendar.isHoliday(aMayFirst));
        assertFalse(persistedHolidayCalendar.isHoliday(aMaySeventh));
    }

    @Test
    public void persistingAHolidayCalendarWithAHolidayRuleDate() {
        HolidayCalendar holidayCalendar = new HolidayCalendar("nombre");
        holidayCalendar.addHolidayRule(new HolidayRuleDate(LocalDate.of(2017, 7, 10)));

        LocalDate aHolidayDate = LocalDate.of(2017, 7, 10);
        LocalDate aNonHolidayDate = LocalDate.of(2017, 5, 17);

        Long id = holidayCalendarService.save(holidayCalendar).getId();
        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findById(id);

        assertTrue(persistedHolidayCalendar.isHoliday(aHolidayDate));
        assertFalse(persistedHolidayCalendar.isHoliday(aNonHolidayDate));
    }

    @Test
    public void persistingAHolidayCalendarWithAHolidayRuleWithInterval() {
        HolidayCalendar holidayCalendar = new HolidayCalendar("nombre");

        LocalDate start = LocalDate.of(2015, 5, 7);
        LocalDate finish = LocalDate.of(2019, 5, 7);
        DateInterval interval = DateInterval.fromDateToDate(start, finish);

        holidayCalendar.addHolidayRule(new HolidayRuleWithInterval(new HolidayRuleDayOfWeek(DayOfWeek.MONDAY), interval));

        LocalDate aMondayInsideInterval = LocalDate.of(2017, 3, 20);
        LocalDate aMondayOutsideInterval = LocalDate.of(2014, 6, 16);

        Long id = holidayCalendarService.save(holidayCalendar).getId();
        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findById(id);

        assertTrue(persistedHolidayCalendar.isHoliday(aMondayInsideInterval));
        assertFalse(persistedHolidayCalendar.isHoliday(aMondayOutsideInterval));
    }

    @Test
    public void aHolidayCalendarCanBeFoundByItsName(){
        HolidayCalendar holidayCalendar = new HolidayCalendar("Alemania");

        holidayCalendarService.save(holidayCalendar);
        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findByNameContaining("MAN").get(0);

        assertEquals("Alemania", persistedHolidayCalendar.name());
    }

    @Test
    public void aHolidayCalendarCanBeUpdated(){
        HolidayCalendar holidayCalendar = new HolidayCalendar("Alemania");
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(DayOfWeek.SATURDAY));
        Long id = holidayCalendarService.save(holidayCalendar).getId();

        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findById(id);
        persistedHolidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(DayOfWeek.SUNDAY));

        holidayCalendarService.update(id, persistedHolidayCalendar);
        HolidayCalendar updatedHolidayCalendar = holidayCalendarService.findById(id);
        LocalDate aSunday = LocalDate.of(2017, 5, 21);

        assertTrue(updatedHolidayCalendar.isHoliday(aSunday));
    }

    @Test
    public void aHolidayRuleCanBeAddedToAHolidayCalendar(){
        HolidayCalendar holidayCalendar = new HolidayCalendar("Alemania");
        Long id = holidayCalendarService.save(holidayCalendar).getId();
        HolidayRuleDayOfMonth newHolidayRule = new HolidayRuleDayOfMonth(MonthDay.of(5,1));

        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.addHolidayRuleToCalendar(id, newHolidayRule);

        LocalDate aFirstOfMay = LocalDate.of(2010, 5,1);

        assertTrue(persistedHolidayCalendar.isHoliday(aFirstOfMay));
    }

}
