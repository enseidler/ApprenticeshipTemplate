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

    disabled() {
        return !holidaysStore.getState().id;
    }

    render() {
        return (
            <div className="form-group year-selector">
                <button
                    className="btn btn-danger"
                    disabled={this.disabled()}
                    onClick={this.decrementYear()} >
                    {"<"}
                </button>
                {" "}
                <span className="badge badge-default badge-pill">{yearStore.getState()}</span>
                {" "}
                <button
                    className="btn btn-danger"
                    disabled={this.disabled()}
                    onClick={this.incrementYear()} >
                    {">"}
                </button>
            </div>
        );
    }
}

export default YearSelector;
