require "rails_helper"

RSpec.describe HolidayCalendarsController, type: :routing do
  describe "routing" do

    it "routes to #index" do
      expect(:get => "/holiday_calendars").to route_to("holiday_calendars#index")
    end

    it "routes to #new" do
      expect(:get => "/holiday_calendars/new").to route_to("holiday_calendars#new")
    end

    it "routes to #show" do
      expect(:get => "/holiday_calendars/1").to route_to("holiday_calendars#show", :id => "1")
    end

    it "routes to #edit" do
      expect(:get => "/holiday_calendars/1/edit").to route_to("holiday_calendars#edit", :id => "1")
    end

    it "routes to #create" do
      expect(:post => "/holiday_calendars").to route_to("holiday_calendars#create")
    end

    it "routes to #update via PUT" do
      expect(:put => "/holiday_calendars/1").to route_to("holiday_calendars#update", :id => "1")
    end

    it "routes to #update via PATCH" do
      expect(:patch => "/holiday_calendars/1").to route_to("holiday_calendars#update", :id => "1")
    end

    it "routes to #destroy" do
      expect(:delete => "/holiday_calendars/1").to route_to("holiday_calendars#destroy", :id => "1")
    end

  end
end
