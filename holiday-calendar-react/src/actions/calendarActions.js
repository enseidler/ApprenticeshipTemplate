import * as types from './actionTypes';
import holidayCalendarsAPI from '../api/HolidayCalendarsAPI';
import { holidaysStore } from "../stores";


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

export function createRule() {
    return function() {
        return holidayCalendarsAPI.createRule()
            .then(() =>
               holidaysStore.dispatch(loadHolidays())
        ).catch(error => {
            throw(error);
        });
    };
}










