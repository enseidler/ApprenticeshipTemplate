package calendar.persistence;

import calendar.model.utils.DateInterval;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class PersistentDateInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public LocalDate start;

    public LocalDate end;

    public PersistentDateInterval() {}

    public PersistentDateInterval(DateInterval interval) {
        start = interval.getStart();
        end = interval.getEnd();
    }

    public static PersistentDateInterval from(DateInterval interval) {
        return new PersistentDateInterval(interval);
    }

    public DateInterval toDateInterval() {
        return DateInterval.fromDateToDate(start, end);
    }
}
