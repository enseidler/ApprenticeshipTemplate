package calendar.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HolidayCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HolidayRule> holidayRules;

    public HolidayCalendar() {
        holidayRules = new ArrayList<>();
    }

    public List<HolidayRule> getHolidayRules() {
        return holidayRules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void setHolidayRules(List<HolidayRule> someHolidayRules) {
        this.holidayRules = someHolidayRules;
    }

    public boolean isHoliday(LocalDate aDate) {
        return holidayRules.stream().anyMatch(rule -> rule.isHoliday(aDate));
    }

    public void addHolidayRule(HolidayRule aHolidayRule) {
        holidayRules.add(aHolidayRule);
    }
}
