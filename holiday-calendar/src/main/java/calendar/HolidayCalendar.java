package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

/**54 11 451468795
 * Created by root on 3/05/17.
 */
public class HolidayCalendar {

    private List<DayOfWeek> daysOfWeekHoliday;
    private List<MonthDay> daysOfMonthHoliday;

    public HolidayCalendar() {
        daysOfWeekHoliday = new ArrayList<DayOfWeek>();
        daysOfMonthHoliday = new ArrayList<MonthDay>();
    }

    public Boolean isHoliday(LocalDate aLocalDate) {
        MonthDay dayOfMonth = MonthDay.of(aLocalDate.getMonthValue(), aLocalDate.getDayOfMonth());
        DayOfWeek dayOfWeek = aLocalDate.getDayOfWeek();
        return isDayOfWeekHoliday(dayOfWeek) ||
                isDayOfMonthHoliday(dayOfMonth);
    }

    private Boolean isDayOfMonthHoliday(MonthDay dayOfMonth) {
        return daysOfMonthHoliday.contains(dayOfMonth);
    }

    private Boolean isDayOfWeekHoliday(DayOfWeek dayOfWeek) {
        return daysOfWeekHoliday.contains(dayOfWeek);
    }

    public void markDayOfWeekAsHoliday(DayOfWeek aDayOfWeek) {
        daysOfWeekHoliday.add(aDayOfWeek);
    }

    public void markDayOfMonthAsHoliday(MonthDay monthDay) {
        daysOfMonthHoliday.add(monthDay);
    }
}
