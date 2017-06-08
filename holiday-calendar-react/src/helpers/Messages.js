/**
 * Created by fede on 08/06/17.
 */

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