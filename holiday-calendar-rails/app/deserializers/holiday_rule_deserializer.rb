class HolidayRuleDeserializer

  def self.deserialize(hashed_rule)
    rule = hashed_rule['type'].constantize.new
    hashed_rule.keys.each do |key|
      rule.send("#{key}=", hashed_rule[key])
    end
    rule
  end

end