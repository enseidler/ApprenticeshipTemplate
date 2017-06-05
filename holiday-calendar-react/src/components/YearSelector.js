import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class YearSelector extends  Component {

    static propTypes = {
        year: PropTypes.number.isRequired,
        incrementYear: PropTypes.func.isRequired,
        decrementYear: PropTypes.func.isRequired
    };

    render() {
        const {year, incrementYear, decrementYear } = this.props;
        return (
            <div className="year-selector">
                <button className="btn btn-secondary" onClick={decrementYear} >
                    {"<"}
                </button>
                {year}
                <button className="btn btn-secondary" onClick={incrementYear} >
                    {">"}
                </button>
            </div>
        );
    }
}
export default YearSelector;