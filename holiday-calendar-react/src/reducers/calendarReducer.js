import * as types from '../actions/actionTypes'

export const calendarReducer = (state = {name: 'unknow'}, action) => {
    switch (action.type) {
        case types.LOAD_CALENDAR_SUCCESS:
            return action.calendar;
        default:
            return state;
    }
}