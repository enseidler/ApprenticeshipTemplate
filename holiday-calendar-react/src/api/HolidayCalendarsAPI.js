
class HolidayCalendarsAPI {

    static loadCalendar() {
        return fetch('http://localhost:3000/calendarios/1')
            .then((response) => response.json());
    }

}

export default HolidayCalendarsAPI