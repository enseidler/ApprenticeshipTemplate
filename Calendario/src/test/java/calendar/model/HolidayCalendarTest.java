package calendar.model;

import calendar.model.utils.DateInterval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.MonthDay;

public class HolidayCalendarTest {

    protected HolidayCalendar holidayCalendar;

    @Before
    public void setUp(){
        holidayCalendar = new HolidayCalendar();
    }

    @Test
    public void test01ADayOfWeekCanBeHoliday(){
        LocalDate aSaturday = LocalDate.of(2017, 4, 29);
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(aSaturday.getDayOfWeek()));
        Assert.assertTrue(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void test02ADayOfWeekCannotBeHoliday(){
        LocalDate aWednesday = LocalDate.of(2017, 5, 3);
        Assert.assertFalse(holidayCalendar.isHoliday(aWednesday));
    }

    @Test
    public void test06MoreThanOneDayOfWeekCanBeHoliday(){
        LocalDate aSaturday = LocalDate.of(2017, 5, 6);
        LocalDate aSunday = LocalDate.of(2017, 5, 7);
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(aSaturday.getDayOfWeek()));
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfWeek(aSunday.getDayOfWeek()));
        Assert.assertTrue(holidayCalendar.isHoliday(aSaturday));
        Assert.assertTrue(holidayCalendar.isHoliday(aSunday));
    }

    @Test
    public void test07ADayOfMonthCanBeHoliday(){
        LocalDate aMayFirst = LocalDate.of(2017, 5, 1);
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfMonth(MonthDay.of(5, 1)));
        Assert.assertTrue(holidayCalendar.isHoliday(aMayFirst));
    }

    @Test
    public void test08MoreThanOneDayOfMonthCanBeHoliday(){
        LocalDate aMayFirst = LocalDate.of(2017, 5, 1);
        LocalDate aMayTwentyFifth = LocalDate.of(2017, 5, 25);
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfMonth(MonthDay.of(5, 1)));
        holidayCalendar.addHolidayRule(new HolidayRuleDayOfMonth(MonthDay.of(5, 25)));
        Assert.assertTrue(holidayCalendar.isHoliday(aMayFirst));
        Assert.assertTrue(holidayCalendar.isHoliday(aMayTwentyFifth));
    }

    @Test
    public void test09ADayOfMonthCannotBeHoliday(){
        LocalDate aMayFifth = LocalDate.of(2017, 5,5);
        Assert.assertFalse(holidayCalendar.isHoliday(aMayFifth));
    }

    @Test
    public void test10ADateCanBeHoliday(){
        LocalDate aMaggiesBirthday = LocalDate.of(2017, 5,7);
        holidayCalendar.addHolidayRule(new HolidayRuleDate(LocalDate.of(2017, 5,7)));
        Assert.assertTrue(holidayCalendar.isHoliday(aMaggiesBirthday));
    }

    @Test
    public void test11MoreThanOneDateCanBeHoliday(){
        LocalDate aMaggiesBirthday = LocalDate.of(2017, 5,7);
        LocalDate aSandrosBirthday = LocalDate.of(2017, 6,26);
        holidayCalendar.addHolidayRule(new HolidayRuleDate(LocalDate.of(2017, 5,7)));
        holidayCalendar.addHolidayRule(new HolidayRuleDate(LocalDate.of(2017, 6,26)));
        Assert.assertTrue(holidayCalendar.isHoliday(aMaggiesBirthday));
        Assert.assertTrue(holidayCalendar.isHoliday(aSandrosBirthday));
    }

    @Test
    public void test12ADateCannotBeHoliday(){
        LocalDate anEzesBirthday = LocalDate.of(2017, 10,16);
        Assert.assertFalse(holidayCalendar.isHoliday(anEzesBirthday));
    }

    @Test
    public void test13ADayOfWeekCanBeHolidayInsideAPeriodOfTime(){
        LocalDate aSaturday = LocalDate.of(2017, 4, 29);
        LocalDate start = LocalDate.of(2015, 5, 7);
        LocalDate finish = LocalDate.of(2019, 5, 7);
        DateInterval interval = DateInterval.fromDateToDate(start, finish);
        HolidayRule aHolidayRule =new HolidayRuleDayOfWeek(aSaturday.getDayOfWeek());
        holidayCalendar.addHolidayRule(new HolidayRuleWithInterval(aHolidayRule, interval));
        Assert.assertTrue(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void test14ADayOfWeekCannotBeHolidayInsideAPeriodOfTime(){
        LocalDate aSaturday = LocalDate.of(2017, 4, 29);
        LocalDate start = LocalDate.of(2015, 5, 7);
        LocalDate finish = LocalDate.of(2019, 5, 7);
        DateInterval interval = DateInterval.fromDateToDate(start, finish);
        Assert.assertFalse(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void test15ADayOfMonthCanBeHolidayInsideAPeriodOfTime(){
        LocalDate aMaggiesBirthday = LocalDate.of(2017, 5,7);
        LocalDate start = LocalDate.of(2015, 5, 7);
        LocalDate finish = LocalDate.of(2019, 5, 7);
        DateInterval interval = DateInterval.fromDateToDate(start, finish);
        HolidayRule aHolidayRule = new HolidayRuleDayOfMonth(MonthDay.of(5,7));
        holidayCalendar.addHolidayRule(new HolidayRuleWithInterval(aHolidayRule, interval));
        Assert.assertTrue(holidayCalendar.isHoliday(aMaggiesBirthday));
    }

    @Test
    public void test16ADayOfMonthWhichIsHolidayInsideAPeriodOfTimeCannotBeHolidayOutsideThatPeriodOfTime(){
        LocalDate aMaggiesBirthday = LocalDate.of(2017, 5,7);
        LocalDate start = LocalDate.of(2018, 5, 7);
        LocalDate finish = LocalDate.of(2019, 5, 7);
        HolidayRule aHolidayRule = new HolidayRuleDayOfMonth(MonthDay.of(5,7));
        DateInterval interval = DateInterval.fromDateToDate(start, finish);
        holidayCalendar.addHolidayRule(new HolidayRuleWithInterval(aHolidayRule,interval));
        Assert.assertFalse(holidayCalendar.isHoliday(aMaggiesBirthday));
    }

}
