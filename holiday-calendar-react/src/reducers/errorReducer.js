/**
 * Created by fede on 08/06/17.
 */

import * as types from '../actions/actionTypes';
const defaultError={
    strong:null,
    msg:null,
    dismiss:"modal"
}
export const errorReducer = (state = defaultError, action) => {
    switch (action.type) {
        case types.CHANGE_ERROR:
            return action.error;
        default:
            return state;
    }
}