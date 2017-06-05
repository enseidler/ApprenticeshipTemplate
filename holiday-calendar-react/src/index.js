import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import { calendarStore, holidaysStore, yearStore, newHolidayRuleStore } from './stores'
import { loadCalendar, loadHolidays } from './actions/calendarActions'
import registerServiceWorker from './registerServiceWorker';
import * as types from './actions/actionTypes'


let rootElement = document.getElementById('root');

holidaysStore.dispatch(loadHolidays());

const render = () => ReactDOM.render(
    <App
        calendar = {calendarStore.getState()}
        holidays = {holidaysStore.getState()}
        newHolidayRule={newHolidayRuleStore.getState()}
        loadCalendar = {() => calendarStore.dispatch(loadCalendar())}
        year={yearStore.getState()}
        incrementYear={() => yearStore.dispatch({
            type: types.INCREMENT_YEAR}
        )}
        decrementYear={() => yearStore.dispatch({
            type: types.DECREMENT_YEAR}
        )}
    />,
    rootElement);

render();
calendarStore.subscribe(render);
holidaysStore.subscribe(render);
yearStore.subscribe(render);

registerServiceWorker();
