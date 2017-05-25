class HolidayRuleDeserializer

  def self.deserialize(hashed_rule)
    rule = hashed_rule['type'].constantize.new
    hashed_rule.keys.each do |key|
      if key == 'holiday_rule'
        rule.send("#{key}=", deserialize(hashed_rule[key]))
      else
        rule.send("#{key}=", hashed_rule[key])
      end
    end
    rule
  end

end