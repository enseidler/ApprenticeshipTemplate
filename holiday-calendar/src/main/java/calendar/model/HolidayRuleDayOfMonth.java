package calendar.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.MonthDay;

@Entity
@JsonTypeName("HolidayRuleDayOfMonth")
public class HolidayRuleDayOfMonth extends HolidayRule {

    @Type(type = "calendar.model.utils.MonthDayUserType")
    private MonthDay dayOfMonthHoliday;

    public HolidayRuleDayOfMonth() {}

    public HolidayRuleDayOfMonth(MonthDay aDayOfMonth) {
        dayOfMonthHoliday = aDayOfMonth;
    }

    public MonthDay getDayOfMonthHoliday() {
        return dayOfMonthHoliday;
    }

    public void setDayOfMonthHoliday(MonthDay aDayOfMonth) {
        this.dayOfMonthHoliday = aDayOfMonth;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return dayOfMonthHoliday.equals(MonthDay.of(aDate.getMonth(), aDate.getDayOfMonth()));
    }
}
