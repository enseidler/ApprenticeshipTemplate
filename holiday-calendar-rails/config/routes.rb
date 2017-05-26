Rails.application.routes.draw do

  get '/calendarios', to: 'holiday_calendars#calendars'

  get '/calendarios/:id', to: 'holiday_calendars#calendar'

  post '/calendarios', to: 'holiday_calendars#create'

  put '/calendarios/:id', to: 'holiday_calendars#update'

  get '/calendarios/:id/feriados', to: 'holiday_calendars#holidays'

  post '/calendarios/:id/reglas_de_feriado', to: 'holiday_calendars#add_rule'

  get 'GET /caliendarios/es_feriado', to: 'holiday_calendars#where_is_holiday'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

end
