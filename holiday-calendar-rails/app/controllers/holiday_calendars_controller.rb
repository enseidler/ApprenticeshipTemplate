class HolidayCalendarsController < ApplicationController

  # GET /calendarios
  def calendars
    calendars = HolidayCalendar.where(['name LIKE ?', "%#{params[:nombre]}%"])
    render json: calendars
  end

  # GET /calendarios/1
  def calendar
    calendar = HolidayCalendar.find(params[:id])
    render json: calendar
  end

  # POST /calendarios
  def create
    rules = params[:holiday_rules].map do |rule|
      HolidayRuleDeserializer.deserialize(rule)
    end
    new_calendar = HolidayCalendar.create!(
      name: params[:name],
      holiday_rules: rules)
    render json: new_calendar
  end

end
