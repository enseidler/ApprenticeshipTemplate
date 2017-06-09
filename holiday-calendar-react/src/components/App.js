import React, { Component } from 'react';
import YearSelector from './YearSelector';
import HolidaysList from './HolidaysList';
import CreateHolidayRule from "./CreateHolidayRule";
import {messageStore, holidaysStore,calendarsStore} from "../stores/index";
import MessagePanel from "./MessagePanel";
import * as types from "../actions/actionTypes"
import {loadHolidays, createCalendar } from "../actions/calendarActions"


class App extends Component {

    render() {
        return (
            <div>
                <nav className="navbar navbar-inverse bg-inverse navbar-toggleable-md justify-content-md-between">
                    <a className="navbar-brand" href="#">
                        <img src="../images/brand.png" width="30" height="30" alt=""/>
                        {" Feriados!"}
                    </a>
                    <a className="navbar-brand" href="#">
                        <h2>{ holidaysStore.getState().name }</h2>
                    </a>

                    <div className="form-inline">
                        <button
                            className="btn btn-outline-danger form-control"
                            disabled={!calendarsStore.getState().name}
                            onClick={function() {
                                calendarsStore.dispatch(createCalendar());
                            }}>
                            {"Crear Calendario"}
                        </button>
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Escribí un nombre..."
                            required
                            onChange={(event)=>
                                calendarsStore.dispatch(
                                    {
                                        type:types.CHANGE_NEW_CALENDAR_NAME,
                                        name: event.target.value
                                    }
                                )}/>
                    </div>

                    <select className="custom-select" onChange={(event) => {
                            var calendar=calendarsStore.getState().calendars.find( calendar => calendar.name===event.target.value)
                            holidaysStore.dispatch({
                                type:types.CHANGE_CALENDAR,
                                calendar:{
                                    id:calendar.id,
                                    name:calendar.name
                                }
                            })
                            holidaysStore.dispatch(loadHolidays());
                        }}
                    >
                        <option selected disabled>Elegí un calendario...</option>
                        {calendarsStore.getState().calendars.map(calendar =>
                            <option>{calendar.name}</option>
                        )}}
                    </select>
                </nav>

                <br/>

                <div className="container">
                    <div className="row">
                        <div className="offset-md-4 col-md-4">
                            <YearSelector />
                        </div>
                    </div>

                    <div className="form-group row">
                        <div className="offset-md-4 col-md-4 scrollable">
                            <HolidaysList />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="offset-md-4 col-md-4">
                            <button
                                href="#myModal"
                                role="button"
                                className="btn btn-danger form-control"
                                disabled={!holidaysStore.getState().id}
                                data-toggle="modal">
                                Agregar Feriado
                            </button>
                        </div>
                    </div>


                    <div className="row">
                        <div className="offset-md-4 col-md-4">
                            <MessagePanel messageStore={messageStore}/>
                        </div>
                    </div>

                    <div className="row">
                        <CreateHolidayRule />
                    </div>

                </div>
            </div>
        );

    }
}

export default App;
