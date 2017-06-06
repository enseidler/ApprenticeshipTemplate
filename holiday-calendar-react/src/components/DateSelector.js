import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { DateField, DatePicker } from 'react-date-picker';
import 'react-date-picker/index.css';
import { holidayFormStore } from '../stores';

export class DateSelector extends Component {

    static propTypes = {
        date: PropTypes.object.isRequired,
        onChangeAction: PropTypes.string.isRequired
    }

    onChange() {
        return (dateString) => holidayFormStore.dispatch({
            type: this.props.onChangeAction,
            date: new Date(dateString.replace(/-/g , "/"))
        });
    }

    render() {
        return (
            <div>
                <DateField
                    dateFormat="YYYY-MM-DD"
                    forceValidDate={true}
                    updateOnDateClick={true}
                    collapseOnDateClick={true}
                    defaultValue={this.props.date.valueOf()}
                    showClock={false}
                    onChange={this.onChange()}>
                    <DatePicker
                        navigation={true}
                        clearButton={false}
                        okButton={false}
                        cancelButton={false}
                        locale="en"
                        forceValidDate={true}
                        highlightWeekends={true}
                        highlightToday={true}
                        weekNumbers={true}
                        weekStartDay={0}/>
                </DateField>
            </div>
        );
    }

}

export default DateSelector;