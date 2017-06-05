import React, { Component } from 'react';
import PropTypes from 'prop-types';
import 'react-date-picker/index.css'
import HolidayRuleDateForm from "./HolidayRuleDateForm";
import HolidayRuleDayOfWeekForm from "./HolidayRuleDayOfWeekForm";
import HolidayRuleDayOfMonthForm from "./HolidayRuleDayOfMonthForm";
import DateSelector from "./DateSelector";

export class CreateHolidayRule extends  Component{

    static propTypes = {
        newHolidayRule: PropTypes.object.isRequired

    };

    render() {
        const {newHolidayRule}=this.props;
        return (
            <div>

                <h3>Nuevo Feriado</h3>

                <HolidayRuleDateForm date={newHolidayRule.date} />

                <HolidayRuleDayOfWeekForm day_of_week={newHolidayRule.dayOfWeek} />

                <HolidayRuleDayOfMonthForm
                    day_of_month={newHolidayRule.dayOfMonth}
                    month={newHolidayRule.month} />

                <h5>Vigencia</h5>
                <div className="row">
                    <div className="col-md-5">
                        Desde
                        <DateSelector/>
                    </div>
                    <div className="offset-md-2 col-md-5">
                        Hasta
                        <DateSelector/>
                    </div>
                </div>
                <button className="btn btn-secondary" >
                    {"crear regla"}
                </button>
            </div>
        );
    }
}

export default CreateHolidayRule;
