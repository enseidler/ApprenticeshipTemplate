package calendar.persistence;

import calendar.model.HolidayRule;
import calendar.model.HolidayRuleDayOfWeek;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.DayOfWeek;


@Entity
@DiscriminatorValue("HolidayRuleDayOfWeek")
public class PersistentHolidayRuleDayOfWeek extends PersistentHolidayRule {

    public DayOfWeek dayOfWeek;

    public PersistentHolidayRuleDayOfWeek() {}

    public PersistentHolidayRuleDayOfWeek(HolidayRuleDayOfWeek aHolidayRuleDayOfWeek) {
        dayOfWeek = aHolidayRuleDayOfWeek.getDayOfWeekHoliday();
    }

    public static PersistentHolidayRule from(HolidayRule aHolidayRule) {
        return new PersistentHolidayRuleDayOfWeek((HolidayRuleDayOfWeek) aHolidayRule);
    }

    @Override
    public HolidayRule toHolidayRule() {
        return new HolidayRuleDayOfWeek(dayOfWeek);
    }

}
