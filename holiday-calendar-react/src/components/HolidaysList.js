import React, { Component } from 'react';
import { holidaysStore } from '../stores';

export class HolidaysList extends Component {

    render() {
        return (
            <ul className="list-group">
            {holidaysStore.getState().holidays.map(date =>
                <li className="list-group-item ">{ date }</li>
            )}
            </ul>
        );
    }

}

export default HolidaysList;