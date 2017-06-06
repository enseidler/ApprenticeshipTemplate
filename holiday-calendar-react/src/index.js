import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import { holidaysStore, holidayFormStore, yearStore} from './stores'
import { loadHolidays } from './actions/calendarActions'
import registerServiceWorker from './registerServiceWorker';


let rootElement = document.getElementById('root');

const render = () => ReactDOM.render(
    <App />,
    rootElement
);

holidaysStore.dispatch(loadHolidays());

render();

holidaysStore.subscribe(render);
holidayFormStore.subscribe(render);
yearStore.subscribe(render);

registerServiceWorker();
