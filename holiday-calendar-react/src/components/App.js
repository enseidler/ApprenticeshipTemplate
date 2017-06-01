import React, { Component } from 'react';
import PropTypes from 'prop-types';

class App extends Component {

    static propTypes = {
        value: PropTypes.object.isRequired,
        cambiar: PropTypes.func.isRequired,
        calendario: PropTypes.func.isRequired
    }

  render() {
    const { value, cambiar, calendario} = this.props
    return (
      <div>
          <h2>Calendarios de Feriados</h2>
          <button onClick={cambiar}>
              cambiar
          </button>
          <button onClick={calendario}>
              calendario
          </button>
          { value.name }
      </div>
    );
  }
}

export default App;
