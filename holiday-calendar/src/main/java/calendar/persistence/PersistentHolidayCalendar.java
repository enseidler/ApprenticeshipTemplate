package calendar.persistence;

import calendar.model.HolidayCalendar;
import calendar.model.HolidayRule;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class PersistentHolidayCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<PersistentHolidayRule> persistentHolidayRules;

    public PersistentHolidayCalendar() {}

    public PersistentHolidayCalendar(List<HolidayRule> someHolidayRules) {
        persistentHolidayRules = someHolidayRules
                                    .stream()
                                    .map(aHolidayRule -> PersistentHolidayRule.from(aHolidayRule))
                                    .collect(Collectors.toList());
    }

    public static PersistentHolidayCalendar from(HolidayCalendar aHolidayCalendar) {
        return new PersistentHolidayCalendar(aHolidayCalendar.getHolidayRules());
    }

    public HolidayCalendar toHolidayCalendar() {
        List<HolidayRule> holidayRules = persistentHolidayRules
                .stream()
                .map(aPersistentHolidayRule -> aPersistentHolidayRule.toHolidayRule())
                .collect(Collectors.toList());
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        holidayRules.stream().forEach(aHolidayRule -> holidayCalendar.addHolidayRule(aHolidayRule));
        return holidayCalendar;
    }
}
