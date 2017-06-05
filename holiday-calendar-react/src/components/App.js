import React, { Component } from 'react';
import PropTypes from 'prop-types';
import YearSelector from './YearSelector';
import HolidaysList from './HolidaysList';

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
          <div className="container">

              <h2>Calendarios de Feriados</h2>

              <div class="row">
                  <div className="offset-md-4 col-md-4">
                      <YearSelector
                          year={ year }
                          incrementYear={ incrementYear }
                          decrementYear={ decrementYear } />
                  </div>
              </div>

              <div class="row">
                  <div className="offset-md-4 col-md-4 scrollable">
                      <HolidaysList holidays={ holidays }/>
                  </div>
              </div>

          </div>
        );
    }
}

export default App;
