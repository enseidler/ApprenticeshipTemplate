import React, { Component } from 'react';
import PropTypes from 'prop-types';

class App extends Component {

    static propTypes = {
        value: PropTypes.object.isRequired,
        calendar: PropTypes.func.isRequired
    }

  render() {
    const { value, calendar} = this.props
    return (
      <div>
          <h2>Calendarios de Feriados</h2>
          <button onClick={calendar}>
              calendario
          </button>
          { value.name }
      </div>
    );
  }
}

export default App;
