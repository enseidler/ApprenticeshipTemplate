
class HolidayCalendarsAPI {

    static loadHolidays() {
        return fetch('http://192.168.1.92:3000/calendarios/1/feriados')
            .then((response) => response.json());
    }

}

export default HolidayCalendarsAPI