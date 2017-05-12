package calendar.persistence;

import calendar.model.HolidayRule;
import calendar.model.HolidayRuleDayOfMonth;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.MonthDay;


@Entity
@DiscriminatorValue("HolidayRuleDayOfMonth")
public class PersistentHolidayRuleDayOfMonth extends PersistentHolidayRule {

    public MonthDay dayOfMonth;

    public PersistentHolidayRuleDayOfMonth() {}

    public PersistentHolidayRuleDayOfMonth(HolidayRuleDayOfMonth aHolidayRuleDayOfMonth) {
        dayOfMonth = aHolidayRuleDayOfMonth.getDayOfMonthHoliday();
    }

    public static PersistentHolidayRule from(HolidayRule aHolidayRule) {
        return new PersistentHolidayRuleDayOfMonth((HolidayRuleDayOfMonth) aHolidayRule);
    }

    @Override
    public HolidayRule toHolidayRule() {
        return new HolidayRuleDayOfMonth(dayOfMonth);
    }

}
