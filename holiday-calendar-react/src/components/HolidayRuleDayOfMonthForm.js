import React, { Component } from 'react';
import HolidayTypeRadio from "./HolidayTypeRadio";
import {holidayFormStore} from "../stores/index"
import * as types from "../actions/actionTypes"
export class HolidayRuleDayOfMonthForm extends Component {

    render() {

        var months = ['Enero', 'Febrero', 'Marzo', 'Abril',
            'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
            'Octubre', 'Noviembre', 'Diciembre'];

        return (
            <div className="row">
                <div className="col-md-6">
                    <HolidayTypeRadio
                        type= 'HolidayRuleDayOfMonth'
                        label= 'Día del mes'
                    />
                </div>
                <div className="col-md-4">
                    <select
                        className="custom-select form-control"
                        value={months[holidayFormStore.getState().month-1]} onChange={(event)=>
                        holidayFormStore.dispatch(
                            {
                                type:types.CHANGE_MONTH,
                                month:months.indexOf(event.target.value)+1
                            })} >
                        {months.map(day =>
                            <option>{day}</option>
                        )}
                    </select>
                </div>
                <div className="col-md-2">
                    <input type="text" className="form-control" size={"1"}
                           placeholder="Dia"
                           value={holidayFormStore.getState().day_of_month_holiday}
                            onChange={(event)=>
                            holidayFormStore.dispatch(
                                {
                                    type:types.CHANGE_DAY_OF_MONTH,
                                    day_of_month_holiday:event.target.value
                                }
                            )}/>
                </div>
            </div>

        );
    }
}

export default HolidayRuleDayOfMonthForm;

