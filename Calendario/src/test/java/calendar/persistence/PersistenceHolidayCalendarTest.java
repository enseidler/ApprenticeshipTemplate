package calendar.persistence;

import calendar.model.HolidayCalendar;
import calendar.model.HolidayRuleDayOfWeek;
import calendar.services.HolidayCalendarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(DayOfWeek.FRIDAY));

        LocalDate aFriday = LocalDate.of(2017, 5, 12);
        LocalDate aSaturday = LocalDate.of(2017, 5, 13);

        Long id = holidayCalendarService.save(holidayCalendar);
        HolidayCalendar persistedHolidayCalendar = holidayCalendarService.findById(id);

        assertTrue(persistedHolidayCalendar.isHoliday(aFriday));
        assertFalse(persistedHolidayCalendar.isHoliday(aSaturday));
    }

}
