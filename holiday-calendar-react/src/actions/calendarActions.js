import * as types from './actionTypes';
import holidayCalendarsAPI from '../api/HolidayCalendarsAPI';


export function loadHolidaysSuccess(holidays) {
    return {
        type: types.LOAD_HOLIDAYS_SUCCESS,
        holidays: holidays
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










