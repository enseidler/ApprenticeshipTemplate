class CreateHolidayRules < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rules do |t|
      t.string :type, null: false

      t.timestamps
    end
  end
end
