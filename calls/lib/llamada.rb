
class Llamada

  def initialize(a_call_interval)
    @intervalo_de_llamada = a_call_interval
  end

  def duracion_en_minutos
    (@intervalo_de_llamada.last - @intervalo_de_llamada.first) / 60
  end

  def fin_de_semana?
    @intervalo_de_llamada.last.saturday?
  end

end