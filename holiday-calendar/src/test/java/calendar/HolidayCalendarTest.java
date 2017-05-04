package calendar;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;


/**
 * Created by root on 3/05/17.
 */
public class HolidayCalendarTest {

    @Test
    public void test01_oneDayOfWeekCanBeHoliday(){
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        LocalDate aSaturday = LocalDate.of(2017, 4, 29);
        holidayCalendar.markDayOfWeekAsHoliday(DayOfWeek.SATURDAY);
        Assert.assertTrue(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void test02_oneDayOfWeekCannotBeHoliday() {
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        LocalDate aWednesday = LocalDate.of(2017, 5, 3);
        Assert.assertFalse(holidayCalendar.isHoliday(aWednesday));
    }

    @Test
    public void test06_moreThanOneDayOfWeekCanBeHoliday() {
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        LocalDate aSunday = LocalDate.of(2017, 5, 7);
        LocalDate aSaturday = LocalDate.of(2017, 5, 6);
        holidayCalendar.markDayOfWeekAsHoliday(DayOfWeek.SUNDAY);
        holidayCalendar.markDayOfWeekAsHoliday(DayOfWeek.SATURDAY);
        Assert.assertTrue(holidayCalendar.isHoliday(aSunday));
        Assert.assertTrue(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void test07_oneDayOfMonthCanBeHoliday() {
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        LocalDate aFirstOfMay = LocalDate.of(2017, 5, 1);
        holidayCalendar.markDayOfMonthAsHoliday(MonthDay.of(5, 1));
        Assert.assertTrue(holidayCalendar.isHoliday(aFirstOfMay));
    }

    @Test
    public void test08_moreThanOneDayOfMonthCanBeHoliday() {
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        LocalDate aFirstOfMay = LocalDate.of(2017, 5, 1);
        LocalDate aTwentyFiveOfMay = LocalDate.of(2017, 5, 25);
        holidayCalendar.markDayOfMonthAsHoliday(MonthDay.of(5, 1));
        holidayCalendar.markDayOfMonthAsHoliday(MonthDay.of(5, 25));
        Assert.assertTrue(holidayCalendar.isHoliday(aFirstOfMay));
        Assert.assertTrue(holidayCalendar.isHoliday(aTwentyFiveOfMay));
    }

}
