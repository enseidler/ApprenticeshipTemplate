
class NumeroTelefonico

  def initialize(un_codigo_de_pais, un_codigo_de_area, un_numero)
    @codigo_de_pais = un_codigo_de_pais
    @codigo_de_area = un_codigo_de_area
    @numero = un_numero

    @codigos_telefonicos_norte_america = [1, 52, 299]
    @codigos_telefonicos_sudamerica = [51, 54, 55, 56, 57, 58, 500, 591, 592, 593, 594, 595, 597, 598]
    @codigos_telefonicos_europa = [30, 31, 32, 33, 34, 36, 39, 40, 41, 43, 44, 45,
                                   46, 47, 48, 49, 350, 351, 352, 353, 354, 355, 356,
                                   357, 358, 359, 370, 371, 372, 373, 374, 375, 376,
                                   377, 378, 379, 380, 381, 382, 383, 384, 385, 386,
                                   387, 389, 420, 421, 423]
  end

  def codigo_de_pais
    @codigo_de_pais
  end

  def codigo_de_area
    @codigo_de_area
  end

  def mismo_pais_distinta_area?(otro_numero)
    @codigo_de_pais == otro_numero.codigo_de_pais && @codigo_de_area != otro_numero.codigo_de_area
  end

  def sudamerica?
    @codigos_telefonicos_sudamerica.include? @codigo_de_pais
  end

  def europa?
    @codigos_telefonicos_europa.include? @codigo_de_pais
  end

  def norte_america?
    @codigos_telefonicos_norte_america.include? @codigo_de_pais
  end

end