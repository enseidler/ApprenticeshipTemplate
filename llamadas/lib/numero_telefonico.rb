
class NumeroTelefonico

  def initialize(un_codigo_de_pais, un_codigo_de_area, un_numero)
    @codigo_de_pais = un_codigo_de_pais
    @codigo_de_area = un_codigo_de_area
    @numero = un_numero
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

end