package calendar.model;

import java.time.LocalDate;


public class HolidayRuleDate extends HolidayRule {

    private LocalDate date;

    public HolidayRuleDate() {}

    public HolidayRuleDate(LocalDate aDate){
        date = aDate;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return aDate.equals(date);
    }
}
