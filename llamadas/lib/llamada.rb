
class Llamada

  def initialize(una_duracion_en_minutos)
    @duracion_en_minutos = una_duracion_en_minutos
  end

  def costo
    if @duracion_en_minutos == 1
      return 0.30
    end
    0.60
  end

end