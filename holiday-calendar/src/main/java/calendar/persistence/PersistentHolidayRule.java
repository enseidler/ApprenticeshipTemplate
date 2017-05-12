package calendar.persistence;


import calendar.model.*;

import javax.persistence.*;


@Entity
public abstract class PersistentHolidayRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public static PersistentHolidayRule from(HolidayRule aHolidayRule) {
        if(aHolidayRule.getClass() == HolidayRuleDayOfWeek.class)
            return PersistentHolidayRuleDayOfWeek.from(aHolidayRule);
        if(aHolidayRule.getClass() == HolidayRuleDayOfMonth.class)
            return PersistentHolidayRuleDayOfMonth.from(aHolidayRule);
        if(aHolidayRule.getClass() == HolidayRuleDate.class)
            return PersistentHolidayRuleDate.from(aHolidayRule);
        if(aHolidayRule.getClass() == HolidayRuleWithInterval.class)
            return PersistentHolidayRuleWithInterval.from(aHolidayRule);
        return null;
    }

    abstract HolidayRule toHolidayRule();

}
