package calendar.repositories;

import calendar.model.HolidayCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface HolidayCalendarRepository extends JpaRepository<HolidayCalendar, Long> {
}
