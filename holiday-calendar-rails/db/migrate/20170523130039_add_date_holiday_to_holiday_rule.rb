class AddDateHolidayToHolidayRule < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :date_holiday, :date
  end
end
