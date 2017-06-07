import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { DateField, DatePicker } from 'react-date-picker';
import 'react-date-picker/index.css';
import { holidayFormStore } from '../stores';

export class DateSelector extends Component {

    static propTypes = {
        date: PropTypes.object.isRequired,
        onChangeAction: PropTypes.string.isRequired,
        onClearAction: PropTypes.string
    }

    onChange() {
        const props=this.props.onChangeAction; //Esto es para poder acceder a las props (dentro de la funcion cambia this)
        return function (dateString){
            var date= new Date(dateString.replace(/-/g , "/"))
            if ( isNaN(date.getTime()) )  {
                   date=null
            }

            holidayFormStore.dispatch({
            type: props,
            date:date
        })
        };
    }

    onClear() {
        return () => holidayFormStore.dispatch({
            type: this.props.onClearAction
        });
    }

    render() {

        return (

            <div>
                <DateField
                    dateFormat="YYYY-MM-DD"
                    forceValidDate={false}
                    updateOnDateClick={true}
                    collapseOnDateClick={true}
                    defaultPrevented={null}
                    showClock={false}
                    onChange={this.onChange()}
                    onClear={this.onClear()}>
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