package calendar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class HolidayCalendar {

    private List<HolidayRule> holidayRules;

    public HolidayCalendar() {
        holidayRules = new ArrayList<>();
    }

    public List<HolidayRule> getHolidayRules() {
        return holidayRules;
    }

    public Boolean isHoliday(LocalDate aDate) {
        return holidayRules.stream().anyMatch(rule -> rule.isHoliday(aDate));
    }

    public void addHolidayRule(HolidayRule aHolidayRule) {
        holidayRules.add(aHolidayRule);
    }

}
