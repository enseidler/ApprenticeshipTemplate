package calendar.persistence;

import calendar.model.HolidayRule;
import calendar.model.HolidayRuleWithInterval;

import javax.persistence.*;


@Entity
@DiscriminatorValue("HolidayRuleWithInterval")
public class PersistentHolidayRuleWithInterval extends PersistentHolidayRule {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public PersistentDateInterval persistentInterval;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public PersistentHolidayRule persistentHolidayRule;

    public PersistentHolidayRuleWithInterval() {}

    public PersistentHolidayRuleWithInterval(HolidayRuleWithInterval aHolidayRuleWithInterval) {
        persistentInterval = PersistentDateInterval.from(aHolidayRuleWithInterval.getInterval());
        persistentHolidayRule = PersistentHolidayRule.from(aHolidayRuleWithInterval.getHolidayRule());
    }

    public static PersistentHolidayRule from(HolidayRule aHolidayRule) {
        return new PersistentHolidayRuleWithInterval((HolidayRuleWithInterval) aHolidayRule);
    }

    @Override
    public HolidayRule toHolidayRule() {
        return new HolidayRuleWithInterval(
                persistentHolidayRule.toHolidayRule(),
                persistentInterval.toDateInterval());
    }

}
