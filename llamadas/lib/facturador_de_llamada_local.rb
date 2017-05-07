class FacturadorDeLlamadaLocal

  def self.puede_facturar_llamada(una_llamada)
    una_llamada.local?
  end

  def costo_de_llamada(una_llamada)
    if una_llamada.hora_pico? && una_llamada.dia_habil?
      return 0.20 * una_llamada.duracion_en_minutos
    end
    0.10 * una_llamada.duracion_en_minutos
  end

end