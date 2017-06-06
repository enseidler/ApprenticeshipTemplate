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
        var date;
        if(this.props.date==null){
            date=null;
        }else{
            date=this.props.date.valueOf()
        }
        return (

            <div>
                <DateField

                    dateFormat="YYYY-MM-DD"
                    forceValidDate={false}
                    updateOnDateClick={true}
                    collapseOnDateClick={true}
                    defaultValue={date}
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