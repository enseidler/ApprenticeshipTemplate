package calendar.rest;

import calendar.model.HolidayCalendar;

public class AddRequest {

    private HolidayCalendar holidayCalendar;

    public HolidayCalendar getHolidayCalendar() {
        return holidayCalendar;
    }

    public void setHolidayCalendar(HolidayCalendar aHolidayCalendar) {
        this.holidayCalendar = aHolidayCalendar;
    }

}
