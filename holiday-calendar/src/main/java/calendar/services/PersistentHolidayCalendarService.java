package calendar.services;


import calendar.model.HolidayCalendar;
import calendar.persistence.PersistentHolidayCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import calendar.repositories.PersistentHolidayCalendarRepository;

import java.util.List;

@Service
public class PersistentHolidayCalendarService {

    @Autowired
    private PersistentHolidayCalendarRepository persistentHolidayCalendarRepository;

    @Transactional
    public PersistentHolidayCalendar save(HolidayCalendar aHolidayCalendar) {
        return persistentHolidayCalendarRepository.save(PersistentHolidayCalendar.from(aHolidayCalendar));
    }

    public List<PersistentHolidayCalendar> findAll() {
        return persistentHolidayCalendarRepository.findAll();
    }

    public PersistentHolidayCalendar findById(Long id) {
        return persistentHolidayCalendarRepository.findOne(id);
    }
}
