import React, { Component } from 'react';
import DateSelector from './DateSelector'
import 'react-date-picker/index.css';
import HolidayTypeRadio from './HolidayTypeRadio';
import { holidayFormStore } from "../stores";
import * as types from '../actions/actionTypes';

export class HolidayRuleDateForm extends Component {

    render() {
        const date_holiday = holidayFormStore.getState().date_holiday;
        return (
            <div className="row">
                <div className="col-md-6">
                    <HolidayTypeRadio
                        type= 'HolidayRuleDate'
                        label= 'Día específico'
                    />
                </div>

                <div className="form-group col-md-6">
                    <DateSelector
                        date={date_holiday}
                        onChangeAction={types.CHANGE_DATE_HOLIDAY} />
                </div>
            </div>
        );
    }
}

export default HolidayRuleDateForm;

