export default (state = {name: 'lala'}, action) => {
    switch (action.type) {
        case 'CALENDARIOS':
            return fetch('http://localhost:3000/calendarios/1')
                .then((response) => response.json())
                .then(function (data) {
                    return data
                });
        default:
            return state;
    }
}