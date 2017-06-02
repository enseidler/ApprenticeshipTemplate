import React, { Component } from 'react';
import PropTypes from 'prop-types';

class App extends Component {

    static propTypes = {
        calendar: PropTypes.object.isRequired,
        loadCalendar: PropTypes.func.isRequired
    }

  render() {
    const { calendar, loadCalendar } = this.props;
    return (
      <div>
          <h2>Calendarios de Feriados</h2>
          <button onClick= {loadCalendar}>
              calendario
          </button>
          { calendar.name }
      </div>
    );
  }
}

export default App;
