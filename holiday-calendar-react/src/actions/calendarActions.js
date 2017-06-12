import * as types from './actionTypes';
import holidayCalendarsAPI from '../api/HolidayCalendarsAPI';
import { holidaysStore, calendarsStore } from "../stores";
import * as messages from "../helpers/Messages";
import {showSuccessMessage} from "../helpers/Messages";


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

export function loadCalendarsSuccess(calendars) {
    return {
        type: types.LOAD_CALENDARS_SUCCESS,
        calendars: calendars
    };
}

export function loadCalendars() {
    return function(dispatch) {
        return holidayCalendarsAPI.loadCalendars()
            .then((calendars) => dispatch(
                loadCalendarsSuccess(calendars)
                )
            ).catch(error => {
                throw(error);
            });
    };
}

export function createRule() {
    return function() {
        return holidayCalendarsAPI.createRule()
            .then(() =>{
                    showSuccessMessage("Nuevo feriado creado!");
                    holidaysStore.dispatch(loadHolidays())
        }
        ).catch(error => {
            throw(error);
        });
    };
}

export function createCalendar() {
    return function() {
        return holidayCalendarsAPI.createCalendar()
            .then(() =>{

                showSuccessMessage("Nuevo calendario creado!");
                    calendarsStore.dispatch(loadCalendars())

                }
            ).catch(error => {
                throw(error);
            });
    };
}








