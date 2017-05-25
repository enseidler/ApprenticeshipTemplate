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
  end

end
