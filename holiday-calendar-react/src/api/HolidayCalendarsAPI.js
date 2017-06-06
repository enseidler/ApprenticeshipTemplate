import { holidayFormStore, yearStore } from "../stores";

class HolidayCalendarsAPI {

    static loadHolidays() {
        var year = yearStore.getState();
        var begins = year + '-01' +'-01';
        var ends = year + '-12' +'-31';
        return fetch('http://192.168.1.92:3000/calendarios/1/feriados?desde=' + begins + '&hasta=' + ends)
            .then((response) => response.json());
    }

    static createRule(){
        var rule = this.newRule(holidayFormStore.getState());
        return fetch('http://192.168.1.92:3000/calendarios/1/reglas_de_feriado',
            {
            method:"post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(rule)});
    }

    static newRule(state) {
        switch (state.ruleType) {
            case 'HolidayRuleDate':
                return this.createNewHolidayDate(state);
            case 'HolidayRuleDayOfMonth':
                return this.createNewHolidayDayOfMonth(state);
            case 'HolidayRuleDayOfWeek':
                return this.createNewHolidayDayOfWeek(state);
        }
    }

    static createNewHolidayDate(state) {
        return {
            type: 'HolidayRuleDate',
            date_holiday: state.date_holiday
        }
    }

    static createNewHolidayDayOfWeek(state) {
        return {
            type: 'HolidayRuleDayOfWeek',
            day_of_week_holiday:state.day_of_week_holiday
        }
    }

    static createNewHolidayDayOfMonth(state) {
        return {
            type: 'HolidayRuleDayOfMonth',
            day_of_month_holiday: state.day_of_month_holiday,
            month: state.month
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