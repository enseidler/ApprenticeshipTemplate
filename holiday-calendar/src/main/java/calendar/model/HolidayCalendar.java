package calendar.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HolidayCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "holiday_calendar_id")
    private Long id;

    @Column
    private String name;

    @JoinColumn(name = "holiday_calendar_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HolidayRule> holidayRules;

    public HolidayCalendar() {}

    public HolidayCalendar(String aName) {
        name = aName;
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

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
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

    public String name() {
        return name;
    }

    public void changeName(String otherName) {
        name = otherName;
    }
}