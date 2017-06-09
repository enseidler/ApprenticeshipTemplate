/**
 * Created by fede on 08/06/17.
 */
import React, { Component } from 'react';
import PropTypes from 'prop-types';



class MessagePanel extends Component {
    static propTypes = {
        messageStore: PropTypes.object.isRequired

    }

    render() {
        const {messageStore}=this.props
        return (
            <div className={"alert alert-"+messageStore.getState().type} role="alert" hidden={!messageStore.getState().strong}>
                <strong>{messageStore.getState().strong}</strong> {messageStore.getState().msg}
            </div>
        );

    }
}

export default MessagePanel;
