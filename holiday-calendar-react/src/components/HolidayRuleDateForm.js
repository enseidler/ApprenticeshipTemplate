import React, { Component } from 'react';
import PropTypes from 'prop-types'
import DateSelector from './DateSelector'
import 'react-date-picker/index.css'
import { holidayFormStore } from "../stores";
import * as types from '../actions/actionTypes';

export class HolidayRuleDateForm extends Component {


    render() {
        const date_holiday = holidayFormStore.getState().date_holiday;
        return (
            <div className="row">
                <div className="col-md-6">
                    <label>
                        <input type="radio" name="ruleType" />
                        {'Día específico'}
                    </label>
                </div>
                <div className="col-md-6">
                    <DateSelector
                    value={date_holiday}
                    onChangeAction={types.CHANGE_DATE_HOLIDAY}/>
                </div>
            </div>
        );
    }
}

export default HolidayRuleDateForm;

