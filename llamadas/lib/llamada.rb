require_relative '../lib/facturador_de_llamada'

class Llamada

  def initialize(una_duracion_en_minutos, un_numero_telefonico, otro_numero_telefonico)
    @duracion_en_minutos = una_duracion_en_minutos
    @numero_origen = un_numero_telefonico
    @numero_destino = otro_numero_telefonico
  end

  def costo
    FacturadorDeLlamada.new.costo_de_llamada(self)
  end

  def duracion_en_minutos
    @duracion_en_minutos
  end

  def nacional?
    @numero_origen.mismo_pais_distinta_area? @numero_destino
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

end
