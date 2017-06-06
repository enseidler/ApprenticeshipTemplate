import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { holidayFormStore } from '../stores';
import * as types from "../actions/actionTypes";

export class HolidayTypeRadio extends Component {

    static propTypes = {
        type: PropTypes.string.isRequired,
        label: PropTypes.string.isRequired
    }

    render() {
        return (
            <div>
                <label>
                    <input
                        type="radio"
                        name="ruleType"
                        value={this.props.type}
                        onChange={(event) => holidayFormStore.dispatch({
                            type: types.CHANGE_RULE_TYPE,
                            ruleType: event.target.value
                        })}
                        checked={this.props.type === (holidayFormStore.getState().ruleType)}/>
                    {this.props.label}
                </label>
            </div>
        );
    }

}

export default HolidayTypeRadio;