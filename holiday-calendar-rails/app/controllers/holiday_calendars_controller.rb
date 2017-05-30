class HolidayCalendarsController < ApplicationController

  # GET /calendarios
  def calendars
    calendars = HolidayCalendar.where(['name LIKE ?', "%#{params[:nombre]}%"])
    render json: calendars
  end

  # GET /calendarios/:id
  def calendar
    calendar = HolidayCalendar.find(params[:id])
    render json: calendar
  end

  # POST /calendarios
  def create
    new_calendar = HolidayCalendar.create!(
      name: calendar_params[:name],
      holiday_rules: rules)
    render json: new_calendar
  end

  # PUT /calendarios/:id
  def update
    updated_calendar = HolidayCalendar.find params[:id]
    updated_calendar.update! name: calendar_params[:name], holiday_rules: rules
    render json: updated_calendar
  end

  # GET /calendarios/:id/feriados
  def holidays
    calendar = HolidayCalendar.find params[:id]
    holidays = calendar.holidays(params[:desde], params[:hasta])
    render json: holidays
  end

  # POST /calendarios/:id/reglas_de_feriado
  def add_rule
    calendar = HolidayCalendar.find params[:id]
    new_rule = HolidayRuleDeserializer.deserialize(rule_params)
    calendar.add_rule(new_rule)
    render json: new_rule
  end

  # GET /calendarios/es_feriado
  def where_is_holiday
    date = params[:fecha] ? Date.parse(params[:fecha]) : Date.today
    calendars = HolidayCalendar.all.select do |calendar|
      calendar.is_holiday? date
    end
    render json: calendars
  end

  def rules
    calendar_params[:holiday_rules].map do |rule|
      HolidayRuleDeserializer.deserialize(rule)
    end
  end


  def calendar_params
    params.permit(:name,
                  {holiday_rules: [:type,
                                   :day_of_week_holiday,
                                   :month,
                                   :day_of_month_holiday,
                                   :date_holiday,
                                   :begins,
                                   :ends,
                                   :holiday_rule => [:type,
                                                     :day_of_week_holiday,
                                                     :month,
                                                     :day_of_month_holiday]]})
  end

  def rule_params
    params.permit(:type,
                  :day_of_week_holiday,
                  :month,
                  :day_of_month_holiday,
                  :date_holiday,
                  :begins,
                  :ends,
                  :holiday_rule => [
                      :type,
                      :day_of_week_holiday,
                      :month,
                      :day_of_month_holiday])
  end


end
