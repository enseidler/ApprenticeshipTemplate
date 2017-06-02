import * as types from '../actions/actionTypes'

export const yearReducer= (state = new Date().getFullYear(), action) => {
    switch (action.type) {
        case types.INCREMENT_YEAR:
            return state + 1
        case types.DECREMENT_YEAR:
            return state - 1
        default:
            return state
    }
}