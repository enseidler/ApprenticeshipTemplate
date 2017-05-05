class ReglaDeFeriadoFecha

  def initialize(una_fecha)
    @fecha_feriado = una_fecha
  end

  def es_feriado?(una_fecha)
    @fecha_feriado.eql? una_fecha
  end

end