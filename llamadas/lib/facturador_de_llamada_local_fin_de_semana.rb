
class FacturadorDeLlamadaLocalFinDeSemana

  def self.puede_facturar_llamada(una_llamada_local)
    !una_llamada_local.dia_habil?
  end

  def costo_de_llamada(una_llamada_local_de_fin_de_semana)
    0.10 * una_llamada_local_de_fin_de_semana.duracion_en_minutos
  end

end