/**
 * Created by fede on 05/06/17.
 */
import * as types from '../actions/actionTypes'
import HolidayCalendarsAPI from "../api/HolidayCalendarsAPI";

newHolidayDefault= {
    checkDay:false,
    checkDayOfWeek:false,
    checkDayOfMonth:false,
    day:"DD-MM-YYYY",
    dayOfWeek:"Seleccione dia",
    dayOfMonth:"Seleccione mes",
    month:null,
    description:"Descripcion",
    since:null,
    until:null
}


export const newHolidayReducer = (state = newHolidayDefault, action) => {
    var newHoliday;

    switch (action.type) {
        case types.CREATE_NEW_HOLIDAY:
            if(state.checkDay){
                newHoliday=HolidayCalendarsAPI.createNewHolidayDate(state)
            }
            if(state.checkDayOfMonth){
                newHoliday=HolidayCalendarsAPI.createNewHolidayDayOfMonth(state)

            }
            if(state.dayOfWeek){
                newHoliday=HolidayCalendarsAPI.createNewHolidayDayOfWeek(state)
            }
            if(state.since!=null && state.until!=null){
                newHoliday=HolidayCalendarsAPI.createNewHolidayWithInterval(state,newHoliday)
            }
            HolidayCalendarsAPI.createNewHolidayRule(newHoliday)
        default:
            return state;
    }
}