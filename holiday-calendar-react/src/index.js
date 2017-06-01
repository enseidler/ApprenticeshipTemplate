import React from 'react';
import ReactDOM from 'react-dom';
import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import App from './components/App';
import registerServiceWorker from './registerServiceWorker';
import calendariosDeFeriado from './reducers';

const store = createStore(calendariosDeFeriado, applyMiddleware(thunk));
let rootElement = document.getElementById('root');

const render = () => ReactDOM.render(
    <App
        value = {store.getState()}
        calendar={() => store.dispatch((dispatch) =>
            fetch('http://localhost:3000/calendarios/1')
                .then((response) => response.json())
                .then((calendar) => dispatch({
                    type: 'GET_CALENDAR',
                    calendar: calendar
                }))
        )}
    />,
    rootElement);

render()
store.subscribe(render)

registerServiceWorker();
