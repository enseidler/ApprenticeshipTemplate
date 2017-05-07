require_relative '../lib/facturador_de_llamada'

class Llamada

  def initialize(un_intervalo_de_llamada, un_numero_telefonico, otro_numero_telefonico)
    @intervalo_de_llamada = un_intervalo_de_llamada
    @numero_origen = un_numero_telefonico
    @numero_destino = otro_numero_telefonico
  end

  def duracion_en_minutos
    (@intervalo_de_llamada.last - @intervalo_de_llamada.first) / 60
  end

  def nacional?
    @numero_origen.mismo_pais_distinta_area? @numero_destino
  end

  def local?
    @numero_origen.mismo_pais_misma_area? @numero_destino
  end

  def internacional?
    @numero_origen.distinto_pais? @numero_destino
  end

  def sudamerica?
    @numero_destino.sudamerica?
  end

  def norte_america?
    @numero_destino.norte_america?
  end

  def europa?
    @numero_destino.europa?
  end

  def dia_habil?
    !@intervalo_de_llamada.first.saturday? && !@intervalo_de_llamada.first.sunday?
  end

  def hora_pico?
    (@intervalo_de_llamada.first.hour > 8) && (@intervalo_de_llamada.last.hour < 20)
  end

end
