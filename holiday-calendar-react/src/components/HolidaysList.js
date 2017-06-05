import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class HolidaysList extends  Component{

    static propTypes = {
        holidays: PropTypes.array.isRequired
    };

    render() {
        const { holidays } = this.props;
        return (
            <ul className="list-group">
            {holidays.map(date =>
                <li className="list-group-item">{date}</li>
            )}
            </ul>
        );
    }

}

export default HolidaysList;