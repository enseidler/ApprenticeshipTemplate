class HolidayCalendarsController < ApplicationController

  # GET /calendarios
  def calendars
    render json: HolidayCalendar.all
  end

  # GET /calendarios/1
  def calendar
    render json: HolidayCalendar.find(params[:id])
  end

end
