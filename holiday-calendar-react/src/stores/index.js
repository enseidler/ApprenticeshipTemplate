import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import { calendarReducer } from '../reducers/calendarReducer'
import { yearReducer } from '../reducers/yearReducer'

export const calendarStore = createStore(calendarReducer, applyMiddleware(thunk));
export const yearStore = createStore(yearReducer);