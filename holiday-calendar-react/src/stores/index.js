import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import { yearReducer } from '../reducers/yearReducer'
import { holidaysReducer } from '../reducers/holidaysReducer'
import { holidayFormReducer } from '../reducers/holidayFormReducer'

export const holidaysStore = createStore(holidaysReducer, applyMiddleware(thunk));
export const holidayFormStore = createStore(holidayFormReducer,applyMiddleware(thunk));
export const yearStore = createStore(yearReducer);
