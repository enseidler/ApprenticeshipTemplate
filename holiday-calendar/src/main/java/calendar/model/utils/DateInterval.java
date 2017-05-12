package calendar.model.utils;

import java.time.LocalDate;


public class DateInterval {

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

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public static DateInterval fromDateToDate(LocalDate aStart, LocalDate anEnd){
        return new DateInterval(aStart,anEnd);
    }

    public Boolean contains(LocalDate aDate) {
        return aDate.isAfter(start) && aDate.isBefore(end) || aDate.equals(start) || aDate.equals(end);
    }
}
