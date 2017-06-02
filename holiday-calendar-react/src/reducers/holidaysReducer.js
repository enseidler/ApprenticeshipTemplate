import * as types from '../actions/actionTypes'

export const holidaysReducer = (state = [], action) => {
    switch (action.type) {
        case types.LOAD_HOLIDAYS_SUCCESS:
            return action.holidays;
        default:
            return state;
    }
}