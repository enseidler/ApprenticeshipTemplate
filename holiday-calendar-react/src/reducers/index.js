
export default (state = {name: 'unknow'}, action) => {
    switch (action.type) {
        case 'GET_CALENDAR':
            return action.calendar
        default:
            return state;
    }
}