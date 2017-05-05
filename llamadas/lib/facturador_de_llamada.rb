require_relative '../lib/facturador_de_llamada_nacional'
require_relative '../lib/facturador_de_llamada_internacional'

class FacturadorDeLlamada

  def initialize
    @facturadores_de_llamadas = [FacturadorDeLlamadaNacional, FacturadorDeLlamadaInternacional]
  end

  def facturador_para_llamada(una_llamada)
    @facturadores_de_llamadas.detect { |facturador|
      facturador.puede_facturar_llamada(una_llamada)
    }.new
  end

  def costo_de_llamada(una_llamada)
    facturador_para_llamada(una_llamada).costo_de_llamada(una_llamada)
  end

end