class HolidayRuleWithPeriodSerializer < ActiveModel::Serializer
  attributes :id, :begins, :ends
  has_one :holiday_rule
end
