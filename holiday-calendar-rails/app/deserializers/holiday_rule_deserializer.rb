class HolidayRuleDeserializer

  def self.deserialize(hashed_rule)
    rule = hashed_rule['type'].constantize.new
    hashed_rule.keys.without('id').each do |key|
      if key == 'holiday_rule'
        rule.try("#{key}=", deserialize(hashed_rule[key]))
      else
        rule.try("#{key}=", hashed_rule[key])
      end
    end
    rule
  end

end