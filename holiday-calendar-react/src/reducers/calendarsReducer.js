/**
 * Created by fede on 08/06/17.
 */
import * as types from '../actions/actionTypes';

const defaultState = {
    name: null,
    calendars: []
};

export const calendarsReducer = (state = defaultState, action) => {
    switch (action.type) {
        case types.LOAD_CALENDARS_SUCCESS:
            state.calendars = action.calendars;
            return state;
        case types.CHANGE_NEW_CALENDAR_NAME:
            state.name = action.name;
            return state;
        default:
            return state;
    }
}