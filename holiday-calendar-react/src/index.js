import React from 'react';
import ReactDOM from 'react-dom';
import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import App from './components/App';
import { loadCalendar } from './actions/HolidayCalendarsActions'
import registerServiceWorker from './registerServiceWorker';
import reducers from './reducers';

const store = createStore(reducers, applyMiddleware(thunk));
let rootElement = document.getElementById('root');

// store.dispatch(loadCalendar());

const render = () => ReactDOM.render(
    <App
        calendar = {store.getState()}
        loadCalendar = {() => store.dispatch(loadCalendar())}
    />,
    rootElement);

render();
store.subscribe(render);

registerServiceWorker();
