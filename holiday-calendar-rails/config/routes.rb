Rails.application.routes.draw do

  get '/calendarios', to: 'holiday_calendars#calendars'

  get '/calendarios/es_feriado', to: 'holiday_calendars#where_is_holiday'

  get '/calendarios/:id', to: 'holiday_calendars#calendar'

  get '/calendarios/:id/feriados', to: 'holiday_calendars#holidays'

  post '/calendarios', to: 'holiday_calendars#create'

  post '/calendarios/:id/reglas_de_feriado', to: 'holiday_calendars#add_rule'

  put '/calendarios/:id', to: 'holiday_calendars#update'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

end
