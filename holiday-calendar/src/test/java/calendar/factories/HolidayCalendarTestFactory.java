package calendar.factories;

import calendar.model.*;
import calendar.model.utils.DateInterval;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

/**
 * Created by ezequiel on 18/05/17.
 */
public class HolidayCalendarTestFactory {

    public HolidayRuleWithInterval newHolidayRuleWithInterval(HolidayRule holidayRule, LocalDate start, LocalDate finish){
        DateInterval interval = new DateInterval(start, finish);
        return new HolidayRuleWithInterval(holidayRule, interval);
    }

    public HolidayRuleDayOfWeek defaultHolidayRuleDayOfWeek(){
        return new HolidayRuleDayOfWeek(DayOfWeek.SATURDAY);
    }

    public HolidayRuleDayOfMonth defaultHolidayRuleDayOfMonth(){
        MonthDay aMayFirst = MonthDay.of(5, 1);
        return new HolidayRuleDayOfMonth(aMayFirst);
    }

    public HolidayRuleDate defaultHolidayRuleDate(){
        return new HolidayRuleDate(LocalDate.of(2017, 5,7));
    }

    public HolidayRuleWithInterval defaultHolidayRuleWithInterval(){
        return newHolidayRuleWithInterval(defaultHolidayRuleDayOfMonth(),
                LocalDate.of(2015, 12, 10),
                LocalDate.of(2019, 12, 10));
    }

}
