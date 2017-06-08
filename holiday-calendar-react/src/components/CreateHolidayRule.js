import React, { Component } from 'react';
import * as types from '../actions/actionTypes'
import 'react-date-picker/index.css';
import HolidayRuleDateForm from "./HolidayRuleDateForm";
import HolidayRuleDayOfWeekForm from "./HolidayRuleDayOfWeekForm";
import HolidayRuleDayOfMonthForm from "./HolidayRuleDayOfMonthForm";
import DateSelector from "./DateSelector";
import { holidayFormStore } from '../stores';
import { createRule } from "../actions/calendarActions";
import { dayExists } from "./helpers/HolidayCalendarHelper";

export class CreateHolidayRule extends  Component{

    validateHolidayRuleDate() {
        var dateHoliday = holidayFormStore.getState().date_holiday;
        return !dateHoliday;
    }

    validateHolidayRuleDayOfMonth() {
        var dayOfMonth = holidayFormStore.getState().day_of_month_holiday;
        return !dayOfMonth || !dayExists(dayOfMonth);
    }

    validateForm() {
        switch (holidayFormStore.getState().ruleType) {
            case 'HolidayRuleDate':
                return this.validateHolidayRuleDate();
            case 'HolidayRuleDayOfMonth':
                return this.validateHolidayRuleDayOfMonth();
            default:
                return false;
        }
    }

    render() {
        const begins=holidayFormStore.getState().begins
        const ends=holidayFormStore.getState().ends

        return (
            <div>
                <div id="myModal" className="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h3 id="myModalLabel">Nuevo Feriado</h3>
                                <button type="button" className="close" data-dismiss="modal" aria-hidden="true">×</button>
                            </div>

                            <div className="modal-body">
                                <div className="offset-md-1 col-md-10">
                                    <HolidayRuleDateForm />
                                    <HolidayRuleDayOfWeekForm />
                                    <HolidayRuleDayOfMonthForm />
                                    <hr/>
                                    <h5>Vigencia</h5>
                                    <div className="form-group row">
                                        <div className="col-md-6">
                                            Desde
                                            <DateSelector
                                                date={begins}
                                                onChangeAction={types.CHANGE_BEGINS}/>
                                        </div>
                                        <div className="col-md-6">
                                            Hasta
                                            <DateSelector
                                                date={ends}
                                                onChangeAction={types.CHANGE_ENDS}/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="modal-footer">
                                <button className="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
                                <button
                                    disabled={this.validateForm()}
                                    className="btn btn-danger"
                                    data-dismiss="modal"
                                    onClick={function() {
                                        holidayFormStore.dispatch(createRule());
                                    }}>
                                    {"Crear Regla"}
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateHolidayRule;
