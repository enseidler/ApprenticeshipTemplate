import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { DateField, DatePicker } from 'react-date-picker'
import 'react-date-picker/index.css'

export class DateSelector extends Component {

    static propTypes = {
        date:PropTypes.number.isRequired
    };


    render() {
        const {date}=this.props
        return (
            <div>
                <DateField
                    dateFormat="YYYY-MM-DD"
                    forceValidDate={true}
                    updateOnDateClick={true}
                    collapseOnDateClick={true}
                    defaultValue={date}
                    showClock={false}>
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