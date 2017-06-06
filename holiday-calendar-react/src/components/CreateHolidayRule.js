import React, { Component } from 'react';
import * as types from '../actions/actionTypes'
import 'react-date-picker/index.css';
import HolidayRuleDateForm from "./HolidayRuleDateForm";
import { holidayFormStore } from '../stores';

export class CreateHolidayRule extends  Component{

    render() {
        return (
            <div>

                <h3>Nuevo Feriado</h3>

                <HolidayRuleDateForm />

                {/*<HolidayRuleDayOfWeekForm />*/}

                {/*<HolidayRuleDayOfMonthForm />*/}

                {/*<h5>Vigencia</h5>*/}
                {/*<div className="row">*/}
                    {/*<div className="col-md-6">*/}
                        {/*Desde*/}
                        {/*<DateSelector />*/}
                    {/*</div>*/}
                    {/*<div className="col-md-6">*/}
                        {/*Hasta*/}
                        {/*<DateSelector />*/}
                    {/*</div>*/}
                {/*</div>*/}
                <div className="btn-group float-right">
                    <button className="btn btn-secondary" >
                        {"Crear Regla"}
                    </button>
                </div>
            </div>
        );
    }
}

export default CreateHolidayRule;
