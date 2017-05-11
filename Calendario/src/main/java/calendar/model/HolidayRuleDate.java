package calendar.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class HolidayRuleDate extends HolidayRule {

    private LocalDate date;

    public HolidayRuleDate() {}

    public HolidayRuleDate(LocalDate aDate){
        date = aDate;
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(LocalDate aDate) {
        this.date = aDate;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return aDate.equals(date);
    }
}
