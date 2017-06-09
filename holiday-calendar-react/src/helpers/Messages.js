/**
 * Created by fede on 08/06/17.
 */
import * as types from "../actions/actionTypes";
import { messageStore } from "../stores";

export const successMessage= (msg)=>{
    return {msg:msg,
            type:'success',
            strong:'EXITO'}
}

export const errorMessage= (msg)=>{
    return {msg:msg,
        type:'danger',
        strong:'ERROR'}
}

export const showSuccessMessage = (message) => {
    messageStore.dispatch({
        type: types.CHANGE_MESSAGE,
        message: successMessage(message)
    });
    setTimeout(() => {
        messageStore.dispatch({
            type: types.CHANGE_MESSAGE,
            message: {
                msg: null,
                type: null,
                strong: null
            }
        });
    } , 3000);
}
