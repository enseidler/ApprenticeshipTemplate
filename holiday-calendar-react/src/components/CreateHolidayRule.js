import React, { Component } from 'react';
import * as types from '../actions/actionTypes'
import 'react-date-picker/index.css';
import HolidayRuleDateForm from "./HolidayRuleDateForm";
import HolidayRuleDayOfWeekForm from "./HolidayRuleDayOfWeekForm";
import HolidayRuleDayOfMonthForm from "./HolidayRuleDayOfMonthForm";
import DateSelector from "./DateSelector";
import { createRule } from "../actions/calendarActions";
import { holidaysStore } from "../stores";
import { dayExists } from "../helpers/HolidayCalendarHelper";
import { connect } from "react-redux";
import PropTypes from "prop-types";


export class CreateHolidayRule extends  Component{
    componentDidMount(){
        const {store}=this.context;
        this.unsubscribe=store.subscribe(()=>this.forceUpdate())
    }
    componentWillUnmount(){
        this.unsubscribe();
    }
    validateHolidayRuleDate() {
        var dateHoliday = this.context.store.getState().date_holiday;
        return !dateHoliday;
    }

    validateHolidayRuleDayOfMonth() {

        var dayOfMonth = this.context.store.getState().day_of_month_holiday;
        return !dayOfMonth || !dayExists(dayOfMonth);
    }

    validateForm() {
        switch (this.context.store.getState().ruleType) {
            case 'HolidayRuleDate':
                return this.validateHolidayRuleDate();
            case 'HolidayRuleDayOfMonth':
                return this.validateHolidayRuleDayOfMonth();
            default:
                return false;
        }
    }

    render() {
        const store=this.context.store
        const state=store.getState()
        const begins=state.begins
        const ends=state.ends

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
                                    data-dismiss={"modal"}
                                    onClick={function() {
                                        store.dispatch(createRule(holidaysStore.getState().id));
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
CreateHolidayRule.contextTypes={
    store:PropTypes.object
}
export default connect()(CreateHolidayRule);
