import * as types from '../actions/actionTypes'

const calendarDefault={
    name: "Elegí un calendario!",
    holidays:[]
}
export const holidaysReducer = (state = calendarDefault, action) => {
    switch (action.type) {
        case types.LOAD_HOLIDAYS_SUCCESS:
            state.holidays=action.holidays;
            return state;
        case types.CHANGE_CALENDAR:
            state.id=action.calendar.id;
            state.name=action.calendar.name;
            state.holidays=[]
            return state;
        default:
            return state;
    }
}