class ReglaDeFeriadoConPeriodo

  def initialize(una_regla_de_feriado, un_periodo)
    @regla_de_feriado = una_regla_de_feriado
    @periodo = un_periodo
  end

  def es_feriado?(una_fecha)
    (@regla_de_feriado.es_feriado? una_fecha) && (@periodo.include? una_fecha)
  end

end