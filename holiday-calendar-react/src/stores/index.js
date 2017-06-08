import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import { yearReducer } from '../reducers/yearReducer'
import { holidaysReducer } from '../reducers/holidaysReducer'
import { holidayFormReducer } from '../reducers/holidayFormReducer'
import { messageReducer } from '../reducers/errorReducer'
import { calendarsReducer } from '../reducers/calendarsReducer'
import * as types from "../actions/actionTypes";
import reduxCatch from 'redux-catch'

function messageHandler(error, getState, lastAction, dispatch) {
    messageStore.dispatch(
        {
            type:types.CHANGE_MESSAGE,
            error:error
        })
    setTimeout(function () {
        messageStore.dispatch(
            {
                type:types.CHANGE_MESSAGE,
                error:{
                    type: null,
                    strong: null,
                    msg:null
                    }
            })
    }, 3000);
}

export const holidaysStore = createStore(holidaysReducer, applyMiddleware(thunk), applyMiddleware(
    reduxCatch(messageHandler)));
export const calendarsStore = createStore(calendarsReducer, applyMiddleware(thunk), applyMiddleware(
    reduxCatch(messageHandler)));
export const holidayFormStore = createStore(holidayFormReducer,applyMiddleware(thunk), applyMiddleware(
    reduxCatch(messageHandler)));
export const yearStore = createStore(yearReducer);
export const messageStore = createStore(messageReducer);
