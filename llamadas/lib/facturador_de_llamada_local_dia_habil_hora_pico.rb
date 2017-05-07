
class FacturadorDeLlamadaLocalDiaHabilHoraPico

  def self.puede_facturar_llamada(una_llamada_local)
    una_llamada_local.hora_pico? && una_llamada_local.dia_habil?
  end

  def costo_de_llamada(una_llamada_local_dia_habil_hora_pico)
    0.20 * una_llamada_local_dia_habil_hora_pico.duracion_en_minutos
  end

end