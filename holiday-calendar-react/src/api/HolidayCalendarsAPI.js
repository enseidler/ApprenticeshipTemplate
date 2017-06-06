
class HolidayCalendarsAPI {

    static loadHolidays() {
        return fetch('http://192.168.1.92:3000/calendarios/1/feriados')
            .then((response) => response.json());
    }

    static createNewHolidayRule(rule){
        fetch('http://192.168.1.92:3000/calendarios/1/reglas_de_feriado',
            {
            method:"post",
            body:JSON.stringify(rule)})

    }

    static createNewHolidayDate(state) {
        return {
            type: 'HolidayRuleDate',
            date_holiday:state.day
        }
    }

    static createNewHolidayDayOfWeek(state) {
        return {
            type: 'HolidayRuleDayOfWeek',
            day_of_week_holiday:state.dayOfWeek
        }
    }

    static createNewHolidayDayOfMonth(state) {
        return {
            type: 'HolidayRuleDayOfMonth',
            day_of_month_holiday:state.dayOfMonth,
            month:state.month
        }
    }

    static createNewHolidayWithInterval(state,holidayRule) {
        return {
            type: 'HolidayRuleWithInterval',
            holiday_rule:holidayRule,
            begins:state.since,
            ends:state.until
        }
    }
}

export default HolidayCalendarsAPI