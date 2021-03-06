require 'time'
require_relative '../lib/numero_telefonico'

class FactoryLlamadas

  # Numeros telefonicos #

  def numero_bsas
    NumeroTelefonico.new(54, 11, 11111111)
  end

  def numero_argentina
    NumeroTelefonico.new(54, 223, 11111111)
  end

  def numero_espanha
    NumeroTelefonico.new(34, 93, 11111111)
  end

  def numero_usa
    NumeroTelefonico.new(1, 201, 11111111)
  end

  def numero_colombia
    NumeroTelefonico.new(57, 85, 11111111)
  end

  def numero_china
    NumeroTelefonico.new(81, 300, 11111111)
  end


  # Intervalos de llamada #

  def un_intervalo_de_10_minutos
    Range.new(Time.new(2017, 4, 29, 12, 00), Time.new(2017, 4, 29, 12, 10))
  end

  def un_intervalo_de_fin_de_semana_de_30_minutos
    Range.new(Time.new(2017, 4, 29, 12, 00), Time.new(2017, 4, 29, 12, 30))
  end

  def un_intervalo_de_dia_habil_hora_pico_de_30_minutos
    Range.new(Time.new(2017, 5, 3, 16, 30), Time.new(2017, 5, 3, 17, 00))
  end

end