require 'rails_helper'

RSpec.describe HolidayCalendar, type: :model do

  let(:calendar) { HolidayCalendar.new }

  it 'test01: un dia de semana puede ser feriado' do
    a_saturday = Date.new(2017, 4, 29)
    calendar.add_rule(HolidayRuleDayOfWeek.create(day_of_week_holiday: a_saturday.cwday))
    expect(calendar.is_holiday? a_saturday).to be_truthy
  end

  it 'test02: un dia de semana puede NO ser feriado' do
    a_wednesday = Date.new(2017, 5, 3)
    expect(calendar.is_holiday? a_wednesday).to be_falsey
  end

  it 'test03: mas de un dia de semana puede ser feriado' do
    a_saturday = Date.new(2017, 5, 6)
    a_sunday = Date.new(2017, 5, 7)
    calendar.add_rule(HolidayRuleDayOfWeek.create(day_of_week_holiday: a_saturday.cwday))
    calendar.add_rule(HolidayRuleDayOfWeek.create(day_of_week_holiday: a_sunday.cwday))
    expect(calendar.is_holiday? a_saturday).to be_truthy
    expect(calendar.is_holiday? a_sunday).to be_truthy
  end

  it 'test04: un dia de mes puede ser feriado' do
    a_may_first = Date.new(2017, 5, 1)
    calendar.add_rule(HolidayRuleDayOfMonth.create(month:5, day_of_month_holiday:1))
    expect(calendar.is_holiday? a_may_first).to be_truthy
  end

  it 'test05: mas de un dia de mes puede ser feriado' do
    a_may_first = Date.new(2017, 5, 1)
    a_may_twenty_fifth = Date.new(2017, 5, 25)
    calendar.add_rule(HolidayRuleDayOfMonth.create(month: 5, day_of_month_holiday: 1))
    calendar.add_rule(HolidayRuleDayOfMonth.create(month: 5, day_of_month_holiday: 25))
    expect(calendar.is_holiday? a_may_first).to be_truthy
    expect(calendar.is_holiday? a_may_twenty_fifth).to be_truthy
  end

  it 'test06: un dia de mes puede NO ser feriado' do
    a_may_first = Date.new(2017, 5, 1)
    expect(calendar.is_holiday? a_may_first).to be_falsey
  end

  it 'test07: una fecha puede ser feriado' do
    a_ezes_birthday = Date.new(2017, 10, 16)
    calendar.add_rule(HolidayRuleDate.create(date_holiday: a_ezes_birthday))
    expect(calendar.is_holiday? a_ezes_birthday).to be_truthy
  end

  it 'test08: mas de una fecha puede ser feriado' do
    a_ezes_birthday = Date.new(2017, 10, 16)
    a_feches_birthday = Date.new(2017, 12, 22)
    calendar.add_rule(HolidayRuleDate.create(date_holiday: a_ezes_birthday))
    calendar.add_rule(HolidayRuleDate.create(date_holiday: a_feches_birthday))
    expect(calendar.is_holiday? a_ezes_birthday).to be_truthy
    expect(calendar.is_holiday? a_feches_birthday).to be_truthy
  end

  it 'test09: una fecha puede NO ser feriado' do
    a_ezes_birthday = Date.new(2017, 10, 16)
    expect(calendar.is_holiday? a_ezes_birthday).to be_falsey
  end

  it 'test10: un dia de la semana puede ser feriado en un period de tiempo' do
    a_saturday = Date.new(2017, 4, 29)
    calendar.add_rule(HolidayRuleWithPeriod.create(
        holiday_rule: HolidayRuleDayOfWeek.create(day_of_week_holiday: a_saturday.cwday),
        begins: Date.new(2015, 10, 12),
        ends: Date.new(2019, 10, 12)))
    expect(calendar.is_holiday? a_saturday).to be_truthy
  end

  it 'test11: un dia de la semana feriado en un period puede ser NO feriado fuera de ese period de tiempo' do
    a_saturday_fuera_del_period = Date.new(2014, 5, 10)
    calendar.add_rule(HolidayRuleWithPeriod.create(
        holiday_rule: HolidayRuleDayOfWeek.create(day_of_week_holiday: a_saturday_fuera_del_period.cwday),
        begins: Date.new(2015, 10, 12),
        ends: Date.new(2019, 10, 12)))
    expect(calendar.is_holiday? a_saturday_fuera_del_period).to be_falsey
  end

  it 'test12: un dia de mes puede ser feriado en un period de tiempo' do
    an_ezes_birthday = Date.new(2017, 10, 16)
    calendar.add_rule(HolidayRuleWithPeriod.create(
        holiday_rule: HolidayRuleDayOfMonth.create(month: 10, day_of_month_holiday: 16),
        begins: Date.new(2015, 10, 12),
        ends: Date.new(2019, 10, 12)))
    expect(calendar.is_holiday? an_ezes_birthday).to be_truthy
  end

  it 'test13: un dia de mes feriado en un period puede ser NO feriado fuera de ese period de tiempo' do
    an_ezes_birthday_outside_period = Date.new(2014, 10, 16)

    calendar.add_rule(HolidayRuleWithPeriod.create(
        holiday_rule: HolidayRuleDayOfMonth.create(month: 10, day_of_week_holiday: 16),
        begins: Date.new(2015, 10, 12),
        ends: Date.new(2019, 10, 12)))
    expect(calendar.is_holiday? an_ezes_birthday_outside_period).to be_falsey
  end

end
