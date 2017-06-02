import React, { Component } from 'react';
import PropTypes from 'prop-types';

class App extends Component {

    static propTypes = {
        calendar: PropTypes.object.isRequired,
        loadCalendar: PropTypes.func.isRequired,
        year: PropTypes.number.isRequired,
        incrementYear: PropTypes.func.isRequired,
        decrementYear: PropTypes.func.isRequired
    };

  render() {
    const { calendar, loadCalendar, year, incrementYear, decrementYear } = this.props;
    return (
      <div>
          <h2>Calendarios de Feriados</h2>

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


          <button onClick= {loadCalendar}>
              calendario
          </button>
          { calendar.name }
      </div>
    );
  }
}

export default App;
