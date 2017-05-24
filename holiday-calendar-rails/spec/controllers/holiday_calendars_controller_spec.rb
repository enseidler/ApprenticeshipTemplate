require 'rails_helper'

RSpec.describe HolidayCalendarsController, type: :controller do

  describe 'GET #calendars' do
    context 'when there are not existing calendars' do
      it 'returns a success response with empty list' do
        get :calendars
        body = JSON.parse(response.body)
        expect(response).to be_success
        expect(body['holiday_calendars']).to eq []
      end
    end

    context 'when there are existing calendars' do
      it 'returns a success response with all calendars' do
        argentina_calendar = HolidayCalendar.create! name: 'Argentina'
        mexico_calendar = HolidayCalendar.create! name: 'Mexico'
        get :calendars
        body = JSON.parse(response.body)
        expect(response).to be_success
        expect(body['holiday_calendars'][0]['id']).to eq argentina_calendar.id
        expect(body['holiday_calendars'][1]['id']).to eq mexico_calendar.id
      end
    end
  end

  describe 'GET #calendar' do
    context 'with :id from calendar without rules' do
      it 'returns a success response with calendar which has :id' do
        argentina_calendar = HolidayCalendar.create! name: 'Argentina'
        get :calendar, params: {id: argentina_calendar.id }
        body = JSON.parse(response.body)
        expect(response).to be_success
        expect(body['holiday_calendar']['id']).to eq argentina_calendar.id

      end
    end
  end

end
