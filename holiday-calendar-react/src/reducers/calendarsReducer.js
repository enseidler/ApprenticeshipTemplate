/**
 * Created by fede on 08/06/17.
 */
import * as types from '../actions/actionTypes';

export const calendarsReducer = (state = [], action) => {
    switch (action.type) {
        case types.LOAD_CALENDARS_SUCCESS:
            return action.calendars;
        default:
            return state;
    }
}