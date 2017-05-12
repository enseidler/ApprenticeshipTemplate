package calendar.repositories;

import calendar.persistence.PersistentHolidayCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface PersistentHolidayCalendarRepository extends JpaRepository<PersistentHolidayCalendar, Long> {
}
