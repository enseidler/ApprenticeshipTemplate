package calendar.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class HolidayRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "holiday_rule_id")
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
