/**
 * Created by fede on 08/06/17.
 */
import React, { Component } from 'react';
import PropTypes from 'prop-types';



class ErrorPanel extends Component {
    static propTypes = {
        errorStore: PropTypes.object.isRequired
    }

    render() {
        const {errorStore}=this.props
        return (

            <div className="alert alert-danger" role="alert" hidden={!errorStore.getState().strong}>
                <strong>{errorStore.getState().strong}</strong> {errorStore.getState().msg}
            </div>
        );

    }
}

export default ErrorPanel;
