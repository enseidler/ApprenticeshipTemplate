import React, { Component } from 'react';

export class HolidayRuleDayOfWeekForm extends  Component{

    render() {
        var days = ['Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo']
        return (
            <div className="row">
                <div className="col-md-6">
                    <label>
                        <input type="radio" name="ruleType"/>
                        {' Día de la semana'}
                    </label>
                </div>
                <div className="col-md-6">
                    <select>
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
