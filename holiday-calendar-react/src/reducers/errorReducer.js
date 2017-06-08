/**
 * Created by fede on 08/06/17.
 */

import * as types from '../actions/actionTypes';
const defaultMessage={
    strong:null,
    msg:null,
    type:null
}
export const messageReducer = (state = defaultMessage, action) => {
    switch (action.type) {
        case types.CHANGE_MESSAGE:
            return action.error;
        default:
            return state;
    }
}