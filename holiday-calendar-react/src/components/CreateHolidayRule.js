import React, { Component } from 'react';
import * as types from '../actions/actionTypes'
import 'react-date-picker/index.css';
import HolidayRuleDateForm from "./HolidayRuleDateForm";
import HolidayRuleDayOfWeekForm from "./HolidayRuleDayOfWeekForm";
import HolidayRuleDayOfMonthForm from "./HolidayRuleDayOfMonthForm";
import DateSelector from "./DateSelector";
import { holidayFormStore, holidaysStore } from '../stores';
import {createRule, loadHolidays} from "../actions/calendarActions";

export class CreateHolidayRule extends  Component{

    render() {
        const begins=holidayFormStore.getState().begins
        const ends=holidayFormStore.getState().ends

        return (
            <div>

                <h3>Nuevo Feriado</h3>

                <hr/>

                <HolidayRuleDateForm />

                <HolidayRuleDayOfWeekForm />

                <HolidayRuleDayOfMonthForm />

                <hr/>

                <h5>Vigencia</h5>
                <div className="form-group row">
                    <div className="col-md-6">
                        Desde
                        <DateSelector
                            date={begins}
                            onChangeAction={types.CHANGE_BEGINS}/>
                     </div>
                    <div className="col-md-6">
                        Hasta
                        <DateSelector
                            date={ends}
                            onChangeAction={types.CHANGE_ENDS} />
                      </div>
                </div>
                <div className="btn-group float-right">
                    <button
                        className="btn btn-secondary"
                        onClick={function() {
                            holidayFormStore.dispatch(createRule());
                        }}>
                        {"Crear Regla"}
                    </button>
                </div>
            </div>
        );
    }
}

export default CreateHolidayRule;
