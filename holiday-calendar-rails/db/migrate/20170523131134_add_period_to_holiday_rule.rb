class AddPeriodToHolidayRule < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :begins, :date
    add_column :holiday_rules, :ends, :date
  end
end
