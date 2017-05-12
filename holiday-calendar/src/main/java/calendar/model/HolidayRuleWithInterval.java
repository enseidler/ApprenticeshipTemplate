package calendar.model;

import calendar.model.utils.DateInterval;

import javax.persistence.*;
import java.time.LocalDate;


public class HolidayRuleWithInterval extends HolidayRule {

    private DateInterval interval;

    private HolidayRule holidayRule;

    public HolidayRuleWithInterval(HolidayRule aHolidayRules, DateInterval anInterval){
        holidayRule = aHolidayRules;
        interval = anInterval;
    }

    public DateInterval getInterval() {
        return interval;
    }

    public HolidayRule getHolidayRule() {
        return holidayRule;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return holidayRule.isHoliday(aDate) && interval.contains(aDate);
    }

}
