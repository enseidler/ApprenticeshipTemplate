package calendar.persistence;

import calendar.model.HolidayRule;
import calendar.model.HolidayRuleDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
@DiscriminatorValue("HolidayRuleDate")
public class PersistentHolidayRuleDate extends PersistentHolidayRule {

    public LocalDate date;

    public PersistentHolidayRuleDate() {}

    public PersistentHolidayRuleDate(HolidayRuleDate aHolidayRuleDate) {
        date = aHolidayRuleDate.getDate();
    }

    public static PersistentHolidayRule from(HolidayRule aHolidayRule) {
        return new PersistentHolidayRuleDate((HolidayRuleDate) aHolidayRule);
    }

    @Override
    public HolidayRule toHolidayRule() {
        return new HolidayRuleDate(date);
    }

}
