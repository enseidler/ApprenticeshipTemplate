package calendar.model.utils;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class DateInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "java.time.LocalDate")
    private LocalDate start;

    @Type(type = "java.time.LocalDate")
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

    public List<LocalDate> containedDates() {
        Long numOfDays = ChronoUnit.DAYS.between(start, end);
        List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1)).limit(numOfDays+1).collect(Collectors.toList());
        return dates;
    }

    public List<LocalDate> containedDatesThatSatisfy(Predicate<LocalDate> condition) {
        return containedDates().stream().filter(condition).collect(Collectors.toList());
    }
}
