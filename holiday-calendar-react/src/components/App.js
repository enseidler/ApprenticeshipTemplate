import React, { Component } from 'react';
import PropTypes from 'prop-types';
import YearSelector from './YearSelector';
import HolidaysList from './HolidaysList';
import CreateHolidayRule from "./CreateHolidayRule";

class App extends Component {

    static propTypes = {
        calendar: PropTypes.object.isRequired,
        loadCalendar: PropTypes.func.isRequired,
        year: PropTypes.number.isRequired,
        incrementYear: PropTypes.func.isRequired,
        decrementYear: PropTypes.func.isRequired,
        holidays: PropTypes.array.isRequired,
        newHolidayRule: PropTypes.object.isRequired
    };


    render() {
        const { calendar, year, incrementYear, decrementYear, holidays,newHolidayRule } = this.props;
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
              <div class="row">
                  <div className="col-md-4">
                      <CreateHolidayRule newHolidayRule={newHolidayRule}/>
                  </div>
              </div>

          </div>
        );
    }
}

export default App;
