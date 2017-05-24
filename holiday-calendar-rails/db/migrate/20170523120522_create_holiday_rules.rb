class CreateHolidayRules < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rules do |t|
      t.string :type, null: false

      t.integer :day_of_week_holiday

      t.integer :month
      t.integer :day_of_month_holiday

      t.date :date_holiday

      t.references :holiday_calendar

      t.references :holiday_rule, foreign_key: true
      t.date :begins
      t.date :ends

      t.timestamps
    end
  end
end
