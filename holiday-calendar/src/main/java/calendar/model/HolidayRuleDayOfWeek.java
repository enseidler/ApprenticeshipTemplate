package calendar.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
public class HolidayRuleDayOfWeek extends HolidayRule {

    private DayOfWeek dayOfWeekHoliday;

    public HolidayRuleDayOfWeek() {}

    public HolidayRuleDayOfWeek(DayOfWeek aDayOfWeek) {
        dayOfWeekHoliday = aDayOfWeek;
    }

    public DayOfWeek getDayOfWeekHoliday() {
        return dayOfWeekHoliday;
    }

    private void setDayOfWeekHoliday(DayOfWeek aDayOfWeek) {
        this.dayOfWeekHoliday = aDayOfWeek;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return dayOfWeekHoliday == aDate.getDayOfWeek();
    }

}
