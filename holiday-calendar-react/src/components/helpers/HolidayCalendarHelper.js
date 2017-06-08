import { holidayFormStore } from "../../stores";

export function selectedMonth() {
    return holidayFormStore.getState().month;
}

export function daysOfSelectedMonth() {
    return new Date(new Date().getFullYear(), selectedMonth(), 0).getDate();
}

export function dayExists(day) {
    return (day >= 1) && (day <= daysOfSelectedMonth());
}
