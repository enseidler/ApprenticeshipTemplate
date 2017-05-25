class HolidayRuleDayOfMonthSerializer < ActiveModel::Serializer
  attributes :type, :id, month, :day_of_month_holiday
end
