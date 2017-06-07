import React, { Component } from 'react';
import {holidayFormStore} from '../stores/index'
import * as types from '../actions/actionTypes'
import HolidayTypeRadio from "./HolidayTypeRadio";

export class HolidayRuleDayOfWeekForm extends  Component{

    render() {

        var days = ['Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo']

        return (
            <div className="row">
                <div className="col-md-6">
                    <HolidayTypeRadio
                        type= 'HolidayRuleDayOfWeek'
                        label= 'Día de la semana'
                    />
                </div>
                <div className="form-group col-md-6">
                    <select
                        className="custom-select form-control"
                        value={days[holidayFormStore.getState().day_of_week_holiday-1]}
                        onChange={(event) => holidayFormStore.dispatch({
                            type:types.CHANGE_DAY_OF_WEEK,
                            day_of_week_holiday:days.indexOf(event.target.value)+1
                        })}>
                        {days.map(day =>
                            <option>{day}</option>
                        )}
                    </select>
                </div>
            </div>
        );
    }
}

export default HolidayRuleDayOfWeekForm;
