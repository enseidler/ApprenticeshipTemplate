class HolidayRuleDayOfWeek < HolidayRule

  def is_holiday?(a_date)
    day_of_week_holiday.eql? a_date.cwday
  end

end
