package calendar.model;

import java.time.LocalDate;
import java.time.MonthDay;


public class HolidayRuleDayOfMonth extends HolidayRule {

    private MonthDay dayOfMonthHoliday;

    public HolidayRuleDayOfMonth(MonthDay aDayOfMonth) {
        dayOfMonthHoliday = aDayOfMonth;
    }

    public MonthDay getDayOfMonthHoliday() {
        return dayOfMonthHoliday;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return dayOfMonthHoliday.equals(MonthDay.of(aDate.getMonth(), aDate.getDayOfMonth()));
    }
}
