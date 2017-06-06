import React, { Component } from 'react';
import { yearStore, holidaysStore } from '../stores'
import * as types from "../actions/actionTypes";
import {loadHolidays} from "../actions/calendarActions";


export class YearSelector extends  Component{

    decrementYear() {
        return (function() {
            yearStore.dispatch({type: types.DECREMENT_YEAR});
            holidaysStore.dispatch(loadHolidays());
        });
    }

    incrementYear() {
        return (function() {
            yearStore.dispatch({type: types.INCREMENT_YEAR});
            holidaysStore.dispatch(loadHolidays());
        });
    }

    render() {
        return (
            <div className="year-selector">
                <button className="btn btn-secondary" onClick={this.decrementYear()} >
                    {"<"}
                </button>
                {" "}
                {yearStore.getState()}
                {" "}
                <button
                    className="btn btn-secondary"
                    onClick={this.incrementYear()} >
                    {">"}
                </button>
            </div>
        );
    }
}

export default YearSelector;
