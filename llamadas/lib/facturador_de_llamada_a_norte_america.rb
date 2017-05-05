
class FacturadorDeLlamadaANorteAmerica

  def self.puede_facturar_llamada(una_llamada_internacional)
    una_llamada_internacional.norte_america?
  end

  def costo_de_llamada(una_llamada_a_norte_america)
    0.70 * una_llamada_a_norte_america.duracion_en_minutos
  end

end