
class FacturadorDeLlamadaAlRestoDelMundo

  def self.puede_facturar_llamada(una_llamada)
    una_llamada.internacional?
  end

  def costo_de_llamada(una_llamada_al_resto_del_mundo)
    1.50 * una_llamada_al_resto_del_mundo.duracion_en_minutos
  end

end