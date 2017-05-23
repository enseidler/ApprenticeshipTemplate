class AddDayOfWeekHolidayToHolidayRule < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :day_of_week_holiday, :integer
  end
end
