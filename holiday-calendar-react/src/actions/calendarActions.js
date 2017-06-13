import * as types from './actionTypes';
import { holidayFormStore, calendarsStore, yearStore } from "../stores";
import { showSuccessMessage } from "../helpers/Messages";
import axios from 'axios';

axios.defaults.baseURL = 'http://192.168.1.92:3000';
axios.defaults.headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
};

function loadCalendarsSuccess(calendars) {
    return {
        type: types.LOAD_CALENDARS_SUCCESS,
        calendars: calendars
    };
}

export function loadCalendars() {
    return function (dispatch) {
        axios.get(`/calendarios`)
            .then((response) => dispatch(loadCalendarsSuccess(response.data)));
    };
}

function loadHolidaysSuccess(holidays) {
    return {
        type: types.LOAD_HOLIDAYS_SUCCESS,
        holidays: holidays
    };
}

export function loadHolidays(id) {
    return function (dispatch) {
        const year = yearStore.getState();
        const begins = year + '-01-01';
        const ends = year + '-12-31';

        const params = {
            desde: begins,
            hasta: ends
        };

        axios.get(`/calendarios/${id}/feriados`, { params: params })
            .then((response) => dispatch(loadHolidaysSuccess(response.data)));
    };
}

export function createCalendar() {
    return function (dispatch) {
        const calendar = newCalendar();

        axios.post(`/calendarios`, JSON.stringify(calendar))
            .then((response) => {
                showSuccessMessage('Nuevo calendario creado!');
                dispatch(loadCalendars());
            });
    };
}

function newCalendar() {
    return {
        name: calendarsStore.getState().name,
        holiday_rules: []
    };
}

export function createRule(id) {
    return function (dispatch) {
        const rule = newRule(holidayFormStore.getState());

        axios.post(`/calendarios/${id}/reglas_de_feriado`, JSON.stringify(rule))
            .then((response) => {
                showSuccessMessage('Nuevo feriado creado!');
                dispatch(loadHolidays(id));
            });
    };
}

function newRule(state) {
    var seudoRule;
    switch (state.ruleType) {
        case 'HolidayRuleDate':
            seudoRule = createNewHolidayDate(state);
            break;
        case 'HolidayRuleDayOfMonth':
            seudoRule = createNewHolidayDayOfMonth(state);
            break;
        case 'HolidayRuleDayOfWeek':
            seudoRule = createNewHolidayDayOfWeek(state);
            break;
    }

    if (state.ends && state.begins) {
        return createNewHolidayWithInterval(state, seudoRule);
    } else {
        return seudoRule;
    }
}

function createNewHolidayDate(state) {
    return {
        type: 'HolidayRuleDate',
        date_holiday: state.date_holiday
    };
}

function createNewHolidayDayOfWeek(state) {
    return {
        type: 'HolidayRuleDayOfWeek',
        day_of_week_holiday: state.day_of_week_holiday
    };
}

function createNewHolidayDayOfMonth(state) {
    return {
        type: 'HolidayRuleDayOfMonth',
        day_of_month_holiday: state.day_of_month_holiday,
        month: state.month
    };
}

function createNewHolidayWithInterval(state,holidayRule) {
    return {
        type: 'HolidayRuleWithPeriod',
        holiday_rule: holidayRule,
        begins: state.begins,
        ends: state.ends
    };
}