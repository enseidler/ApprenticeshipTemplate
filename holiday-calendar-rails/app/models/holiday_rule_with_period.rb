class HolidayRuleWithPeriod < HolidayRule

  belongs_to :holiday_rule

  def is_holiday?(a_date)
    (holiday_rule.is_holiday? a_date) && (period.include? a_date)
  end

  def period
    Range.new(begins, ends)
  end

end
