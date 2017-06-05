import React, { Component } from 'react';
import PropTypes from 'prop-types';
import DateSelector from './DateSelector'
import 'react-date-picker/index.css'

export class HolidayRuleDateForm extends  Component{


    static propTypes = {
        date: PropTypes.object.isRequired,

    };


    render() {

        const { date } = this.props;
        return (
            <div className="row">
                <div className="col-md-6">
                    <label>
                        <input type="radio" name="ruleType" />
                        {'Día específico'}
                    </label>
                </div>
                <div className="col-md-6">
                    <DateSelector date={date.valueOf()}  />
                </div>
            </div>
        );
    }
}

export default HolidayRuleDateForm;

