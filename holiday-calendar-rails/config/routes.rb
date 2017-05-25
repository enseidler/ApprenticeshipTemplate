Rails.application.routes.draw do

  get '/calendarios', to: 'holiday_calendars#calendars'

  get '/calendarios/:id', to: 'holiday_calendars#calendar'

  post '/calendarios', to: 'holiday_calendars#create'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

end