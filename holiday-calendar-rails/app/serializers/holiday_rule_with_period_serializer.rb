class HolidayRuleWithPeriodSerializer < ActiveModel::Serializer
  attributes :type, :id, :begins, :ends
  has_one :holiday_rule
end
