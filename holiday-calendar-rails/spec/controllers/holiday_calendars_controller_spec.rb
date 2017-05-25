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
    context '' do
      it 'returns a success response with created calendar' do
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
  end

end
