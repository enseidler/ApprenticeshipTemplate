require_relative '../lib/numero_telefonico'

class FactoryDeNumerosTelefonicos

  def numero_bsas
    NumeroTelefonico.new(54, 11, 11111111)
  end

  def numero_argentina
    NumeroTelefonico.new(54, 223, 11111111)
  end

  def numero_espanha
    NumeroTelefonico.new(34, 93, 11111111)
  end

  def numero_usa
    NumeroTelefonico.new(1, 201, 11111111)
  end

  def numero_colombia
    NumeroTelefonico.new(57, 85, 11111111)
  end

  def numero_china
    NumeroTelefonico.new(81, 300, 11111111)
  end

end