package calendar.web;

public class Endpoints {

    public static final String HOME = "";
    public static final String ADD_CALENDAR = HOME + "/calendarios";
    public static final String ALL_CALENDARS = HOME + "/calendarios";
    public static final String GET_CALENDAR = HOME + "/calendarios/{id}";
    public static final String UPDATE_CALENDAR = HOME + "/calendarios/{id}";
    public static final String HOLIDAYS_DURING = HOME + "/calendarios/{id}/feriados";
    public static final String ADD_HOLIDAY_RULE = HOME + "/calendarios/{id}/reglas_de_feriado";

}
