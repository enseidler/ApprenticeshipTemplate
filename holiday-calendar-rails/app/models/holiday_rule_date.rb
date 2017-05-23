class HolidayRuleDate < HolidayRule

  def is_holiday?(a_date)
    date_holiday.eql? a_date
  end

end
