require 'rails_helper'

RSpec.describe HolidayCalendarsController, type: :controller do

  describe 'GET #calendars' do
    context 'when there there is no :match param' do
      it 'returns a success response with all existent calendars' do
        argentina_calendar = HolidayCalendar.create! name: 'Argentina'
        mexico_calendar = HolidayCalendar.create! name: 'Mexico'

        get :calendars
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body[0]['id']).to eq argentina_calendar.id
        expect(body[1]['id']).to eq mexico_calendar.id
      end
    end

    context 'when there there is :nombre param' do
      it 'returns a success response with all existent calendars that match :nombre with name' do
        argentina_calendar = HolidayCalendar.create! name: 'Argentina'
        HolidayCalendar.create! name: 'Mexico'
        rusia_calendar = HolidayCalendar.create! name: 'Rusia'

        get :calendars, params: {nombre: 'a'}
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body[0]['id']).to eq argentina_calendar.id
        expect(body[1]['id']).to eq rusia_calendar.id
      end
    end

    context 'when there there is :nombre param and do not matches with any calendar name' do
      it 'returns a success response with an empty list' do
        HolidayCalendar.create! name: 'Argentina'
        HolidayCalendar.create! name: 'Rusia'

        get :calendars, params: {nombre: 'mex'}
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body).to eq []
      end
    end
  end

  describe 'GET #calendar' do
    context 'with :id from calendar without rules' do
      it 'returns a success response with calendar which has :id' do
        argentina_calendar = HolidayCalendar.create! name: 'Argentina'
        get :calendar, params: {id: argentina_calendar.id}
        body = JSON.parse(response.body)
        expect(response).to be_success
        expect(body['id']).to eq argentina_calendar.id
      end
    end
  end

  describe 'POST #create' do
    context 'with a :name and :holiday_rules empty' do
      it 'returns a success response with a calendar without rules' do
        json_body_request = {
            name: 'Argentina',
            holiday_rules: []
        }
        post :create, params: json_body_request, as: :json
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body['name']).to eq 'Argentina'
        expect(body['holiday_rules']).to eq []
      end
    end

    context 'with a :name and :holiday_rules with one HolidayRuleDayOfWeek' do
      it 'returns a success response with a calendar with that rule' do
        json_body_request = {
            name: 'Argentina',
            holiday_rules: [
                {type: 'HolidayRuleDayOfWeek', day_of_week_holiday: 3}
            ]
        }
        post :create, params: json_body_request, as: :json
        body = JSON.parse(response.body)
        created_calendar = HolidayCalendar.find body['id']
        a_wednesday = Date.new(2017, 6, 21)

        expect(response).to be_success
        expect(body['name']).to eq 'Argentina'
        expect(created_calendar.is_holiday? a_wednesday).to be_truthy
      end
    end

    context 'with a :name and :holiday_rules with one HolidayRuleDayOfMonth' do
      it 'returns a success response with a calendar with that rule' do
        json_body_request = {
            name: 'Argentina',
            holiday_rules: [
                {type: 'HolidayRuleDayOfMonth', month: 5, day_of_month_holiday: 1}
            ]
        }
        post :create, params: json_body_request, as: :json
        body = JSON.parse(response.body)
        created_calendar = HolidayCalendar.find body['id']
        a_may_first = Date.new(2017, 5, 1)

        expect(response).to be_success
        expect(body['name']).to eq 'Argentina'
        expect(created_calendar.is_holiday? a_may_first).to be_truthy
      end
    end

    context 'with a :name and :holiday_rules with one HolidayRuleDate' do
      it 'returns a success response with a calendar with that rule' do
        json_body_request = {
            name: 'Argentina',
            holiday_rules: [
                {type: 'HolidayRuleDate', date_holiday: '2017-01-01'}
            ]
        }
        post :create, params: json_body_request, as: :json
        body = JSON.parse(response.body)
        created_calendar = HolidayCalendar.find body['id']
        a_date_holiday = Date.new(2017, 1, 1)

        expect(response).to be_success
        expect(body['name']).to eq 'Argentina'
        expect(created_calendar.is_holiday? a_date_holiday).to be_truthy
      end
    end

    context 'with a :name and :holiday_rules with one HolidayRuleWithPeriod' do
      it 'returns a success response with a calendar with that rule' do
        json_body_request = {
            name: 'Argentina',
            holiday_rules: [
                {
                    type: 'HolidayRuleWithPeriod',
                    holiday_rule: {type: 'HolidayRuleDayOfMonth', month: 10, day_of_month_holiday: 16},
                    begins: '2017-01-01',
                    ends: '2017-12-31'
                }
            ]
        }
        post :create, params: json_body_request, as: :json
        body = JSON.parse(response.body)
        created_calendar = HolidayCalendar.find body['id']
        a_october_sixteen_inside_period = Date.new(2017, 10, 16)
        a_october_sixteen_outside_period = Date.new(2018, 10, 16)

        expect(response).to be_success
        expect(body['name']).to eq 'Argentina'
        expect(created_calendar.is_holiday? a_october_sixteen_inside_period).to be_truthy
        expect(created_calendar.is_holiday? a_october_sixteen_outside_period).to be_falsey
      end
    end
  end

  describe 'PUT #update' do
    context 'with a :name and :holiday_rules with one HolidayRuleDate' do
      it 'returns a success response with a calendar with that rule' do
        calendar_to_update = HolidayCalendar.create! name: 'Groenlandia'

        json_body_request = {
            id: calendar_to_update.id,
            name: 'Nuevo Nombre',
            holiday_rules: [
                {type: 'HolidayRuleDate', date_holiday: '2017-01-01'},
                {type: 'HolidayRuleDayOfWeek', day_of_week_holiday: 1},
            ]
        }
        put :update, params: json_body_request, as: :json
        body = JSON.parse(response.body)
        created_calendar = HolidayCalendar.find body['id']
        a_date_holiday = Date.new(2017, 1, 1)
        a_monday = Date.new(2017, 5, 1)

        expect(response).to be_success
        expect(body['name']).to eq 'Nuevo Nombre'
        expect(body['holiday_rules'].size).to eq 2
        expect(created_calendar.is_holiday? a_date_holiday).to be_truthy
        expect(created_calendar.is_holiday? a_monday).to be_truthy
      end
    end
  end

  describe 'PUT #update' do
    context 'with a :name and :holiday_rules' do
      it 'returns a success response with the updated calendar' do
        calendar_to_update = HolidayCalendar.create! name: 'Groenlandia'

        json_body_request = {
            id: calendar_to_update.id,
            name: 'Nuevo Nombre',
            holiday_rules: [
                {type: 'HolidayRuleDate', date_holiday: '2017-01-01'},
                {type: 'HolidayRuleDayOfWeek', day_of_week_holiday: 1},
            ]
        }
        put :update, params: json_body_request, as: :json
        body = JSON.parse(response.body)
        created_calendar = HolidayCalendar.find body['id']
        a_date_holiday = Date.new(2017, 1, 1)
        a_monday = Date.new(2017, 5, 1)

        expect(response).to be_success
        expect(body['name']).to eq 'Nuevo Nombre'
        expect(body['holiday_rules'].size).to eq 2
        expect(created_calendar.is_holiday? a_date_holiday).to be_truthy
        expect(created_calendar.is_holiday? a_monday).to be_truthy
      end
    end
  end

  describe 'GET #holidays' do
    context 'with :desde and :hasta' do
      it 'returns a success response with all holidays between :desde and :hasta' do
        a_calendar = HolidayCalendar.create! name: 'Groenlandia'
        a_calendar.add_rule(HolidayRuleDayOfMonth.create! month: 5, day_of_month_holiday: 1)
        a_calendar.add_rule(HolidayRuleDate.create! date_holiday: '2018-10-16')

        parameters = {
            id: a_calendar.id,
            desde: '2018-01-01',
            hasta: '2018-12-31'
        }
        get :holidays, params: parameters
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body).to eq ['2018-05-01', '2018-10-16']
      end
    end

    context 'without :desde and :hasta' do
      it 'returns a success response with all holidays on current year' do
        a_calendar = HolidayCalendar.create! name: 'Groenlandia'
        a_calendar.add_rule(HolidayRuleDayOfMonth.create! month: 5, day_of_month_holiday: 1)
        a_calendar.add_rule(HolidayRuleDate.create! date_holiday: '2018-10-16')
        a_calendar.add_rule(HolidayRuleDate.create! date_holiday: '2017-05-18')

        get :holidays, params: {id: a_calendar.id}
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body).to eq ['2017-05-01', '2017-05-18']
      end
    end

    context 'with :desde and without :hasta' do
      it 'returns a success response with all holidays from :desde to last day of current year' do
        a_calendar = HolidayCalendar.create! name: 'Groenlandia'
        a_calendar.add_rule(HolidayRuleDayOfMonth.create! month: 7, day_of_month_holiday: 15)

        get :holidays, params: {id: a_calendar.id, desde: '2016-01-01'}
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body).to eq ['2016-07-15', '2017-07-15']
      end
    end

    context 'without :desde and with :hasta' do
      it 'returns a success response with all holidays from first day of current year to :hasta' do
        a_calendar = HolidayCalendar.create! name: 'Groenlandia'
        a_calendar.add_rule(HolidayRuleDayOfMonth.create! month: 5, day_of_month_holiday: 1)

        get :holidays, params: {id: a_calendar.id, hasta: '2019-01-01'}
        body = JSON.parse(response.body)

        expect(response).to be_success
        expect(body).to eq ['2017-05-01', '2018-05-01']
      end
    end
  end

  describe 'POST #add_rule' do
    context 'with a holiday rule json' do
      it 'returns a success response with created rule' do
        a_calendar = HolidayCalendar.create! name: 'Italia'

        json_body_request = {
            id: a_calendar.id,
            type: 'HolidayRuleDayOfWeek',
            day_of_week_holiday: 3
        }
        post :add_rule, params: json_body_request, as: :json
        a_wednesday = Date.new(2017, 5, 3)

        expect(response).to be_success
        expect(a_calendar.is_holiday? a_wednesday).to be_truthy
      end
    end
  end

end
