class CreateHolidayCalendars < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_calendars do |t|
      t.string :name

      t.timestamps
    end
  end
end
