import React, { Component } from 'react';
import HolidayTypeRadio from "./HolidayTypeRadio";
import {holidayFormStore} from "../stores/index"
import * as types from "../actions/actionTypes"
import {daysOfSelectedMonth} from "./helpers/HolidayCalendarHelper";


export class HolidayRuleDayOfMonthForm extends Component {

    months = ['Enero', 'Febrero', 'Marzo', 'Abril',
    'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
    'Octubre', 'Noviembre', 'Diciembre'];

    render() {
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
                        value={this.months[holidayFormStore.getState().month-1]} onChange={(event)=>
                        holidayFormStore.dispatch(
                            {
                                type:types.CHANGE_MONTH,
                                month:this.months.indexOf(event.target.value)+1
                            })} >
                        {this.months.map(day =>
                            <option>{day}</option>
                        )}
                    </select>
                </div>
                <div className="col-md-2">
                    <input
                        type="number"
                        className="form-control"
                        placeholder="Dia"
                        value={holidayFormStore.getState().day_of_month_holiday}
                        required
                        min={1}
                        max={daysOfSelectedMonth()}
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

