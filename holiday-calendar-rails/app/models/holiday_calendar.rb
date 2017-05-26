class HolidayCalendar < ApplicationRecord

  has_many :holiday_rules

  def add_rule(a_holiday_rule)
    holiday_rules << a_holiday_rule
    save!
  end

  def is_holiday?(a_date)
    holiday_rules.any? { |rule| rule.is_holiday? a_date }
  end

  def holidays(from, to)
    dates_between(from, to).select do |date|
      is_holiday? date
    end
  end

  def dates_between(from, to)
    from_date = from ? Date.parse(from) : Date.new(Date.today.year, 1, 1)
    to_date = to ? Date.parse(to) : Date.new(Date.today.year, 12, 31)
    from_date..to_date
  end

end
