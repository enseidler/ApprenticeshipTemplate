import React, { Component } from 'react';
import HolidayTypeRadio from "./HolidayTypeRadio";

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
                <div className="col-md-3">
                    <select>
                        {months.map(day =>
                            <option>{day}</option>
                        )}
                    </select>
                </div>
                <div className="col-md-3">
                    <input type="text" size={"1"} placeholder="Dia"/>
                </div>
            </div>

        );
    }
}

export default HolidayRuleDayOfMonthForm;

