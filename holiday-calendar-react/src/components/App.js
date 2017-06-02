import React, { Component } from 'react';
import PropTypes from 'prop-types';
import YearSelector from './YearSelector';
import HolidaysList from './HolidaysList';
import './App.css'


class App extends Component {

    static propTypes = {
        calendar: PropTypes.object.isRequired,
        loadCalendar: PropTypes.func.isRequired,
        year: PropTypes.number.isRequired,
        incrementYear: PropTypes.func.isRequired,
        decrementYear: PropTypes.func.isRequired,
        holidays: PropTypes.array.isRequired
    };


    render() {
        const { calendar, year, incrementYear, decrementYear, holidays } = this.props;
        return (
          <div>
              <h2>Calendarios de Feriados</h2>
              <YearSelector year={year} incrementYear={incrementYear} decrementYear={decrementYear} />
              <div className="scrollable">
                    <HolidaysList holidays={holidays}/>
              </div>
          </div>
        );
    }
}

export default App;
