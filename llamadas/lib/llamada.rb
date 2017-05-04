
class Llamada

  def initialize(una_duracion_en_minutos, un_numero_telefonico, otro_numero_telefonico)
    @duracion_en_minutos = una_duracion_en_minutos
    @numero_origen = un_numero_telefonico
    @numero_destino = otro_numero_telefonico
  end

  def costo
    if nacional?
      return 0.30 * @duracion_en_minutos
    end
    0.70 * @duracion_en_minutos
  end

  def nacional?
    @numero_origen.mismo_pais_distinta_area? @numero_destino
  end


end