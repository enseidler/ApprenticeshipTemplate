import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import { yearReducer } from '../reducers/yearReducer'
import { holidaysReducer } from '../reducers/holidaysReducer'
import { holidayFormReducer } from '../reducers/holidayFormReducer'
import { errorReducer } from '../reducers/errorReducer'
import * as types from "../actions/actionTypes";
import reduxCatch from 'redux-catch'

function errorHandler(error, getState, lastAction, dispatch) {

    errorStore.dispatch(
        {
            type:types.CHANGE_ERROR,
            error:{
                strong: 'ERROR',
                msg:error.message,
                dismiss:null
                 }
        })
    setTimeout(function () {
        errorStore.dispatch(
            {
                type:types.CHANGE_ERROR,
                error:{
                    strong: null,
                    msg:null,
                    dismiss:"modal"
                    }
            })
    }, 3000);
}

export const holidaysStore = createStore(holidaysReducer, applyMiddleware(thunk), applyMiddleware(
    reduxCatch(errorHandler)));
export const holidayFormStore = createStore(holidayFormReducer,applyMiddleware(thunk), applyMiddleware(
    reduxCatch(errorHandler)));
export const yearStore = createStore(yearReducer);
export const errorStore = createStore(errorReducer);
