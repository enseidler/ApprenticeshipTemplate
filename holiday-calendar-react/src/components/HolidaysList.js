import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class HolidaysList extends  Component{

    static propTypes = {
        holidays: PropTypes.array.isRequired
    };

    render() {
        const { holidays } = this.props;
        return (
            <table>
                <tbody>
                {holidays.map(date =>
                    <tr>
                        <td>{date}</td>
                    </tr>
                )}
                </tbody>
            </table>
        );
    }

}

export default HolidaysList;