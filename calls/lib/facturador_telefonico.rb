
class FacturadorTelefonico

  def costo_de_llamada(una_llamada)
    if una_llamada.fin_de_semana?
      return 0.10 * una_llamada.duracion_en_minutos
    end
    0.30 * una_llamada.duracion_en_minutos
  end

end