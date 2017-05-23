class AddMonthDayToHolidayRule < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :month, :integer
    add_column :holiday_rules, :day_of_month_holiday, :integer
  end
end
