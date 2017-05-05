
class FacturadorDeLlamadaASudamerica

  def self.puede_facturar_llamada(una_llamada_internacional)
    una_llamada_internacional.sudamerica?
  end

  def costo_de_llamada(una_llamada_a_sudamerica)
    0.50 * una_llamada_a_sudamerica.duracion_en_minutos
  end

end