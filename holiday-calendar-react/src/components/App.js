import React, { Component } from 'react';
import YearSelector from './YearSelector';
import HolidaysList from './HolidaysList';
import CreateHolidayRule from "./CreateHolidayRule";

class App extends Component {

    render() {
        return (
          <div className="container">

              <h2>Calendarios de Feriados</h2>

              <div class="row">
                  <div className="offset-md-4 col-md-4">
                      <YearSelector />
                  </div>
              </div>

              <div class="row">
                  <div className="offset-md-4 col-md-4 scrollable">
                      <HolidaysList />
                  </div>
              </div>

              <div className="row">
                <CreateHolidayRule />
              </div>

          </div>
        );
    }
}

export default App;
