import * as types from './actionTypes';
import holidayCalendarsAPI from '../api/HolidayCalendarsAPI';

export function loadCalendarSuccess(calendar) {
    return {
        type: types.LOAD_CALENDAR_SUCCESS,
        calendar: calendar
    };
}

export function loadHolidaysSuccess(holidays) {
    return {
        type: types.LOAD_HOLIDAYS_SUCCESS,
        holidays: holidays
    };
}

export function loadCalendar() {
    return function(dispatch) {
        return holidayCalendarsAPI.loadCalendar()
            .then((calendar) => dispatch(
                loadCalendarSuccess(calendar)
            )
        ).catch(error => {
            throw(error);
        });
    };
}

export function loadHolidays() {
    return function(dispatch) {
        return holidayCalendarsAPI.loadHolidays()
            .then((holidays) => dispatch(
                loadHolidaysSuccess(holidays)
            )
        ).catch(error => {
            throw(error);
        });
    };
}









