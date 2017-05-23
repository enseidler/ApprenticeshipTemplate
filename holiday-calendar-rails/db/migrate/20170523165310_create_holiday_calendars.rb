class CreateHolidayCalendars < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_calendars do |t|
      t.integer :holiday_rules, :holiday_rule_id

      t.timestamps
    end
  end
end
