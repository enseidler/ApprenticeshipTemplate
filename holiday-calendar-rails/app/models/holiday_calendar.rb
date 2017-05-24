class HolidayCalendar < ApplicationRecord

  has_many :holiday_rules

  def add_rule(a_holiday_rule)
    holiday_rules << a_holiday_rule
    save!
  end

  def is_holiday?(a_date)
    holiday_rules.any? { |rule| rule.is_holiday? a_date }
  end

end
