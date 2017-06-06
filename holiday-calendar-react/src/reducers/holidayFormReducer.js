import * as types from '../actions/actionTypes'
import holidayCalendarsAPI from '../api/HolidayCalendarsAPI';

const defaultState = {
    date_holiday: new Date(),
    ruleType: 'HolidayRuleDate'
}

export const holidayFormReducer = (state = defaultState, action) => {
    switch (action.type) {
        case types.CHANGE_DATE_HOLIDAY:
            state.date_holiday = action.date;
            return state;
        case types.CHANGE_RULE_TYPE:
            state.ruleType = action.ruleType;
            return state;
        case types.CREATE_NEW_HOLIDAY:
            holidayCalendarsAPI.createRule({
                type:'HolidayRuleDate',
                date_holiday: state.date_holiday.toISOString().slice(0, 10)
            });
            return state;
        default:
            return state;
    }
}