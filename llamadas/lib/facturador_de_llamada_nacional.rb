class FacturadorDeLlamadaNacional

  def self.puede_facturar_llamada(una_llamada)
    una_llamada.nacional?
  end

  def costo_de_llamada(una_llamada)
    0.30 * una_llamada.duracion_en_minutos
  end

end