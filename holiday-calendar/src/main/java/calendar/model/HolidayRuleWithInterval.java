package calendar.model;

import calendar.model.utils.DateInterval;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class HolidayRuleWithInterval extends HolidayRule {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DateInterval interval;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private HolidayRule holidayRule;

    public HolidayRuleWithInterval() {}

    public HolidayRuleWithInterval(HolidayRule aHolidayRules, DateInterval anInterval){
        holidayRule = aHolidayRules;
        interval = anInterval;
    }

    public DateInterval getInterval() {
        return interval;
    }

    public void setInterval(DateInterval aDateInterval) {
        this.interval = aDateInterval;
    }

    public HolidayRule getHolidayRule() {
        return holidayRule;
    }

    public void setHolidayRule(HolidayRule aHolidayRule) {
        this.holidayRule = aHolidayRule;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return holidayRule.isHoliday(aDate) && interval.contains(aDate);
    }

}
