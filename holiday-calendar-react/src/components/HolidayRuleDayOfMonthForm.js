import React, { Component } from 'react';

export class HolidayRuleDayOfMonthForm extends Component {

    render() {
        return (
            <div className="row">
                <div className="col-md-6">
                    <label>
                        <input type="radio" name="ruleType"/>
                        {' Día del mes'}
                    </label>
                </div>
                <div className="col-md-3">
                    <select>
                        {Array.apply(null,Array(12)).map((_,i)=>{return i+1;}).map(day =>
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

