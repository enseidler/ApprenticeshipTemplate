require_relative '../lib/facturador_de_llamada_a_europa'
require_relative '../lib/facturador_de_llamada_a_norte_america'
require_relative '../lib/facturador_de_llamada_a_sudamerica'
require_relative '../lib/facturador_de_llamada_al_resto_del_mundo'

class FacturadorDeLlamadaInternacional

  def initialize
    @facturadores_de_llamadas_internacionales = [
        FacturadorDeLlamadaAEuropa,
        FacturadorDeLlamadaASudamerica,
        FacturadorDeLlamadaANorteAmerica,
        FacturadorDeLlamadaAlRestoDelMundo
    ]
  end

  def self.puede_facturar_llamada(una_llamada)
    una_llamada.internacional?
  end

  def costo_de_llamada(una_llamada_internacional)
    facturador_para_llamada_internacional(una_llamada_internacional).costo_de_llamada(una_llamada_internacional)
  end

  def facturador_para_llamada_internacional(una_llamada_internacional)
    @facturadores_de_llamadas_internacionales.detect { |facturador|
      facturador.puede_facturar_llamada(una_llamada_internacional)
    }.new
  end

end