import * as types from '../actions/actionTypes'
import HolidayCalendarsAPI from "../api/HolidayCalendarsAPI";

const newHolidayDefault= {
    ruleType: null,
    date:new Date(),
    dayOfWeek:7,
    dayOfMonth:"Seleccione mes",
    month:null,
    description:"Descripcion",
    since:null,
    until:null
}


export const newHolidayRuleReducer = (state = newHolidayDefault, action) => {

    switch (action.type) {
        case types.CREATE_NEW_HOLIDAY:
            var newHoliday;
            switch (action.holidayType){
                case types.HOLIDAY_RULE_DATE:
                    newHoliday=HolidayCalendarsAPI.createNewHolidayDate(state);
                case types.HOLIDAY_RULE_DAY_OF_WEEK:
                    newHoliday=HolidayCalendarsAPI.createNewHolidayDayOfWeek(state);
                case types.HOLIDAY_RULE_DAY_OF_MONTH:
                    newHoliday=HolidayCalendarsAPI.createNewHolidayDayOfMonth(state);
            }

            if(state.since!=null && state.until!=null){
               return HolidayCalendarsAPI.createNewHolidayRule(
                   HolidayCalendarsAPI.createNewHolidayWithInterval(state,newHoliday))
            }
            return HolidayCalendarsAPI.createNewHolidayRule(newHoliday)
        default:
            return state;
    }
}