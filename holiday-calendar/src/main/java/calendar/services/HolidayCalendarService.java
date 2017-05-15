package calendar.services;


import calendar.model.HolidayCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import calendar.repositories.HolidayCalendarRepository;

import java.util.List;

@Service
public class HolidayCalendarService {

    @Autowired
    private HolidayCalendarRepository holidayCalendarRepository;

    @Transactional
    public Long save(HolidayCalendar aHolidayCalendar) {
        return holidayCalendarRepository.save(aHolidayCalendar).getId();
    }

    public List<HolidayCalendar> findAll() {
        return holidayCalendarRepository.findAll();
    }

    public HolidayCalendar findById(Long id) {
        return holidayCalendarRepository.findOne(id);
    }

}
