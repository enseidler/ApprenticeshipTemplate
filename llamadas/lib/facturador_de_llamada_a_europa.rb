
class FacturadorDeLlamadaAEuropa

  def self.puede_facturar_llamada(una_llamada_internacional)
    una_llamada_internacional.europa?
  end

  def costo_de_llamada(una_llamada_a_europa)
    0.70 * una_llamada_a_europa.duracion_en_minutos
  end

end