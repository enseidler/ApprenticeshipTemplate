import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import { calendarReducer } from '../reducers/calendarReducer'
import { yearReducer } from '../reducers/yearReducer'
import { holidaysReducer } from '../reducers/holidaysReducer'
import { newHolidayRuleReducer } from '../reducers/newHolidayRuleReducer'

export const calendarStore = createStore(calendarReducer, applyMiddleware(thunk));
export const holidaysStore = createStore(holidaysReducer, applyMiddleware(thunk));
export const yearStore = createStore(yearReducer);
export const newHolidayRuleStore=createStore(newHolidayRuleReducer);