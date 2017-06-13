import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import { holidaysStore, holidayFormStore, yearStore, messageStore,calendarsStore} from './stores'
import { loadHolidays, loadCalendars } from './actions/calendarActions'
import registerServiceWorker from './registerServiceWorker';

let rootElement = document.getElementById('root');


const render = () => ReactDOM.render(
    <App />,
    rootElement
);
calendarsStore.dispatch(loadCalendars());

render();

holidaysStore.subscribe(render);
holidayFormStore.subscribe(render);
yearStore.subscribe(render);
messageStore.subscribe(render);
calendarsStore.subscribe(render);
registerServiceWorker();

