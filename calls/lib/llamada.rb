
class Llamada

  def initialize(a_call_interval, un_numero_telefonico, otro_numero_telefonico)
    @numero_origen = un_numero_telefonico
    @numero_destino = otro_numero_telefonico
    @intervalo_de_llamada = a_call_interval
  end

  def duracion_en_minutos
    (@intervalo_de_llamada.last - @intervalo_de_llamada.first) / 60
  end

  def fin_de_semana?
    @intervalo_de_llamada.last.saturday?
  end

  def nacional?
    true
  end

end