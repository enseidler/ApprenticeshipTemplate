class HolidayRuleDayOfMonth < HolidayRule

  def is_holiday?(a_date)
    (month.eql? a_date.month) && (day_of_month_holiday.eql? a_date.day)
  end

end
