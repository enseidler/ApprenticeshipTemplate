
class Llamada

  def initialize(una_duracion_en_minutos)
    @duracion_en_minutos = una_duracion_en_minutos
  end

  def costo
    0.30 * @duracion_en_minutos
  end

end