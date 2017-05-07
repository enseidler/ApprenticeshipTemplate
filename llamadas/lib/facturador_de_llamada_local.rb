require_relative '../lib/facturador_de_llamada_local_dia_habil_hora_pico'
require_relative '../lib/facturador_de_llamada_local_fin_de_semana'

class FacturadorDeLlamadaLocal

  def initialize
    @facturadores_de_llamadas_internacionales = [
        FacturadorDeLlamadaLocalDiaHabilHoraPico,
        FacturadorDeLlamadaLocalFinDeSemana
    ]
  end

  def self.puede_facturar_llamada(una_llamada)
    una_llamada.local?
  end

  def costo_de_llamada(una_llamada_local)
    facturador_para_llamada_local(una_llamada_local).costo_de_llamada(una_llamada_local)
  end

  def facturador_para_llamada_local(una_llamada_local)
    @facturadores_de_llamadas_internacionales.detect { |facturador|
      facturador.puede_facturar_llamada(una_llamada_local)
    }.new
  end

end