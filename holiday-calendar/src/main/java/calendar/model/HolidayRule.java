package calendar.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public abstract class HolidayRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected HolidayRule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    abstract boolean isHoliday(LocalDate aDate);
}
