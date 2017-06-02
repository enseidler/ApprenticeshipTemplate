import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class YearSelector extends  Component{
    static propTypes = {
        year: PropTypes.number.isRequired,
        incrementYear: PropTypes.func.isRequired,
        decrementYear: PropTypes.func.isRequired
    };
    render() {
        const {year, incrementYear, decrementYear } = this.props;
        return (
            <div>
                  <button onClick={decrementYear} >
                    {"<"}
                </button>
                {" "}
                <input size="10"
                       value={year} >
                </input>
                {" "}
                <button onClick={incrementYear} >
                    {">"}
                </button>
            </div>
        );
    }
}
export default YearSelector;