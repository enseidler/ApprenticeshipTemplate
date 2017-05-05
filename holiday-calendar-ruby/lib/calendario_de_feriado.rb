
class CalendarioDeFeriado

  @reglas_de_feriado

  def initialize
    @reglas_de_feriado = []
  end

  def es_feriado?(una_fecha)
    @reglas_de_feriado.any? { |regla| regla.es_feriado? una_fecha }
  end

  def agregar_regla_de_feriado(una_regla)
    @reglas_de_feriado << una_regla
  end
end