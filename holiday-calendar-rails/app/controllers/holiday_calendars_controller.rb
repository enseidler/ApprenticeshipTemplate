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
      name: params[:name],
      holiday_rules: rules)
    render json: new_calendar
  end

  # PUT /calendarios/:id
  def update
    updated_calendar = HolidayCalendar.find params[:id]
    updated_calendar.update! name: params[:name], holiday_rules: rules
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
    new_rule = HolidayRuleDeserializer.deserialize(params.except(:id))
    calendar.add_rule(new_rule)
    render json: new_rule
  end

  # GET /caliendarios/es_feriado
  def where_is_holiday
    date = params[:fecha] ? Date.parse(params[:fecha]) : Date.today
    calendars = HolidayCalendar.all.select do |calendar|
      calendar.is_holiday? date
    end
    render json: calendars
  end



  def rules
    params[:holiday_rules].map do |rule|
      HolidayRuleDeserializer.deserialize(rule)
    end
  end

end
