class ReglaDeFeriadoDiaDeSemana

  def initialize(un_dia_de_semana)
    @dia_de_mes = un_dia_de_semana
  end

  def es_feriado?(una_fecha)
    @dia_de_mes.eql? una_fecha.cwday
  end

end