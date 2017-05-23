# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20170523165310) do

  create_table "holiday_calendars", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.integer "holiday_rules"
    t.integer "holiday_rule_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "holiday_rules", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8" do |t|
    t.string "type", null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.integer "day_of_week_holiday"
    t.integer "month"
    t.integer "day_of_month_holiday"
    t.date "date_holiday"
    t.date "begins"
    t.date "ends"
    t.bigint "holiday_rule_id"
    t.index ["holiday_rule_id"], name: "index_holiday_rules_on_holiday_rule_id"
  end

  add_foreign_key "holiday_rules", "holiday_rules"
end
