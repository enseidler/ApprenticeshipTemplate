import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux'
import App from './components/App';
import registerServiceWorker from './registerServiceWorker';
import calendariosDeFeriado from './reducers';

const store = createStore(calendariosDeFeriado);
let rootElement = document.getElementById('root');

const render = () => ReactDOM.render(
    <App
        value = {store.getState()}
        cambiar = {() => store.dispatch({ type: 'CAMBIAR' })}
        calendario = {() => store.dispatch({ type: 'CALENDARIO' })}
    />,
    rootElement);

render()
store.subscribe(render)

registerServiceWorker();
