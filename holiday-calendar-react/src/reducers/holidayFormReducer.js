import * as types from '../actions/actionTypes'
import holidayCalendarsAPI from '../api/HolidayCalendarsAPI';

const defaultState = {
    date_holiday: new Date(),
    ruleType: 'HolidayRuleDate',
    month:12,
    day_of_month_holiday:22,
    day_of_week_holiday:7
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
            holidayCalendarsAPI.createRule(state);
            return state;
        case types.CHANGE_MONTH:
            state.month=action.month;
            return state;
        case types.CHANGE_DAY_OF_MONTH:
            state.day_of_month_holiday=action.day_of_month_holiday
            return state;
        case types.CHANGE_DAY_OF_WEEK:
            state.day_of_week_holiday=action.day_of_week_holiday
            return state;
        default:
            return state;
    }
}