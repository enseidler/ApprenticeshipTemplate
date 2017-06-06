import React, { Component } from 'react';
import { yearStore } from '../stores'
import * as types from "../actions/actionTypes";


export class YearSelector extends  Component{

    decrementYear() {
        return (() => yearStore.dispatch({type: types.DECREMENT_YEAR}))
    }

    incrementYear() {
        return (() => yearStore.dispatch({type: types.INCREMENT_YEAR}))
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
                <button className="btn btn-secondary" onClick={this.incrementYear()} >
                    {">"}
                </button>
            </div>
        );
    }
}

export default YearSelector;
