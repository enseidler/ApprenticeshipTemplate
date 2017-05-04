require 'rspec'
require_relative '../lib/llamada'
require_relative '../lib/numero_telefonico'

describe 'Llamada' do

  context 'cuando la llamada es nacional' do
    it 'cuesta 30 centavos por minuto' do
      una_llamada_nacional = Llamada.new(14,
                                         NumeroTelefonico.new(54, 11, 11111111),
                                         NumeroTelefonico.new(54, 223, 22222222))
      expect(una_llamada_nacional.costo).to eq 4.20 # dinero
    end
  end

  context 'cuando la llamada es a Europa' do
    it 'cuesta 70 centavos por minutos' do
      una_llamada_a_europa = Llamada.new(20,
                                         NumeroTelefonico.new(54, 11, 11111111),
                                         NumeroTelefonico.new(34, 93, 22222222))
      expect(una_llamada_a_europa.costo).to eq 14.00 # dinero
    end
  end

end