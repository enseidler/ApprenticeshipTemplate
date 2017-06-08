import { holidayFormStore, yearStore} from "../stores";
import * as messages from "../helpers/Messages";
class HolidayCalendarsAPI {

    static loadHolidays() {
        var year = yearStore.getState();
        var begins = year + '-01' +'-01';
        var ends = year + '-12' +'-31';
        return fetch('http://192.168.1.92:3000/calendarios/1/feriados?desde=' + begins + '&hasta=' + ends,
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            .then((response) => response.json());
    }

    static createRule(){
        var rule = this.newRule(holidayFormStore.getState());
        if(Object.values(rule).includes(null)){

            throw messages.errorMessage('datos incorrectos')
        }
        throw messages.successMessage('datos validos')
        return fetch('http://192.168.1.92:3000/calendarios/1/reglas_de_feriado',
            {
            method:"post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(rule)})
    }

    static newRule(state) {
        var seudoRule;
        switch (state.ruleType) {
            case 'HolidayRuleDate':
                seudoRule= this.createNewHolidayDate(state);
                break;
            case 'HolidayRuleDayOfMonth':
                seudoRule= this.createNewHolidayDayOfMonth(state);
                break;
            case 'HolidayRuleDayOfWeek':
                seudoRule=this.createNewHolidayDayOfWeek(state);
                break;
        }
        if((state.begins!=null) && (state.ends!=null)){
            return this.createNewHolidayWithInterval(state,seudoRule);
        }
        else{
            return seudoRule;
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
            type: 'HolidayRuleWithPeriod',
            holiday_rule:holidayRule,
            begins:state.begins,
            ends:state.ends
        }
    }
}

export default HolidayCalendarsAPI