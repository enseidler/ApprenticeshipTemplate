package calendar.model;

import javax.persistence.*;
import java.time.LocalDate;

public abstract class HolidayRule {

    abstract boolean isHoliday(LocalDate aDate);

}
