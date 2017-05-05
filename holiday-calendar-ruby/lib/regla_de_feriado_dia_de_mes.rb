class ReglaDeFeriadoDiaDeMes

  def initialize(un_mes, un_dia_de_mes)
    @mes = un_mes
    @dia_de_mes = un_dia_de_mes
  end

  def es_feriado?(una_fecha)
    (@mes.eql? una_fecha.month) && (@dia_de_mes.eql? una_fecha.day)
  end

end