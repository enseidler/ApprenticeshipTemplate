import React, { Component } from 'react';
import YearSelector from './YearSelector';
import HolidaysList from './HolidaysList';
import CreateHolidayRule from "./CreateHolidayRule";
import {messageStore} from "../stores/index";
import MessagePanel from "./MessagePanel";



class App extends Component {

    render() {

        return (

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
                        <a href="#myModal" role="button" className="btn btn-danger form-control" data-toggle="modal">Agregar
                            Feriado</a>
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
        );

    }
}

export default App;
