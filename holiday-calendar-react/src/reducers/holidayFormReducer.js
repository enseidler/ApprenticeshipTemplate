import * as types from '../actions/actionTypes'

const defaultState = {
    date_holiday: new Date()
}

export const holidayFormReducer = (state = defaultState, action) => {
    switch (action.type) {
        case types.CHANGE_DATE_HOLIDAY:
            state.date_holiday = action.date;
            return state;
        default:
            return state;
    }
}