package calendar.model.utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class DateInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate start;

    private LocalDate end;

    public DateInterval() {}

    public DateInterval(LocalDate aStart, LocalDate anEnd){
        if(aStart.isAfter(anEnd)){
            throw new RuntimeException("Intervalo no valido, la fecha de inicio debe de ser menor a la de fin");
        }
        start = aStart;
        end = anEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate aStart) {
        this.start = aStart;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate anEnd) {
        this.end = anEnd;
    }

    public static DateInterval fromDateToDate(LocalDate aStart, LocalDate anEnd){
        return new DateInterval(aStart,anEnd);
    }

    public Boolean contains(LocalDate aDate) {
        return aDate.isAfter(start) && aDate.isBefore(end) || aDate.equals(start) || aDate.equals(end);
    }
}
