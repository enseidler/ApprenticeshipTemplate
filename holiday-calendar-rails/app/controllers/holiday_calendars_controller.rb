class HolidayCalendarsController < ApplicationController

  # GET /calendarios
  def calendars
    calendars = HolidayCalendar.all
    render json: calendars
  end

  # GET /calendarios/1
  def calendar
    calendar = HolidayCalendar.find(params[:id])
    render json: calendar
  end

end
