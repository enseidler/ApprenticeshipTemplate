package calendar.repositories;

import calendar.model.HolidayCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface HolidayCalendarRepository extends JpaRepository<HolidayCalendar, Long> {

   List<HolidayCalendar> findByNameContainingIgnoreCase(String aName);

}
