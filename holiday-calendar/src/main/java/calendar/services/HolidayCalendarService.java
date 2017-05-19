package calendar.services;


import calendar.model.HolidayCalendar;
import calendar.model.HolidayRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import calendar.repositories.HolidayCalendarRepository;

import java.util.List;

@Service
public class HolidayCalendarService {

    @Autowired
    private HolidayCalendarRepository holidayCalendarRepository;

    @Transactional
    public HolidayCalendar save(HolidayCalendar aHolidayCalendar) {
        return holidayCalendarRepository.save(aHolidayCalendar);
    }

    public List<HolidayCalendar> findAll() {
        return holidayCalendarRepository.findAll();
    }

    public HolidayCalendar findById(Long id) {
        return holidayCalendarRepository.findOne(id);
    }

    public List<HolidayCalendar> findByNameContaining(String aName){
        return holidayCalendarRepository.findByNameContainingIgnoreCase(aName);
    }

    public Boolean existsWithName(String aName) {
        return !findByNameContaining(aName).isEmpty();
    }

    public void clear() {
        holidayCalendarRepository.deleteAll();
    }

    public HolidayCalendar update(Long id, HolidayCalendar newHolidayCalendar) {
        HolidayCalendar holidayCalendar = this.findById(id);
        holidayCalendar.replaceHolidayRules(newHolidayCalendar.holidayRules());
        return this.save(holidayCalendar);
    }

    public HolidayCalendar addHolidayRuleToCalendar(Long id, HolidayRule newHolidayRule) {
        HolidayCalendar holidayCalendar = findById(id);
        holidayCalendar.addHolidayRule(newHolidayRule);

        return save(holidayCalendar);
    }
}
