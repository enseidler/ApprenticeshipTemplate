package calendar.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@JsonTypeName("HolidayRuleDate")
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
