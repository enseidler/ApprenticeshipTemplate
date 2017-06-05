import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class HolidayRuleDayOfWeekForm extends  Component{

    static propTypes = {
        day_of_week:PropTypes.number.isRequired
    };

    render() {
        const {day_of_week}=this.props
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
                    <select value={days[day_of_week-1]}>
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
