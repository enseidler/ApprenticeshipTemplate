require 'rspec'
require_relative '../lib/llamada'
require_relative '../lib/numero_telefonico'

describe 'Llamada' do

  let(:factory) { FactoryDeNumerosTelefonicos.new }

  context 'cuando la llamada es nacional' do
    it 'cuesta 30 centavos por minuto' do
      una_llamada_nacional = Llamada.new(14,
                                         factory.numero_bsas,
                                         factory.numero_argentina)
      expect(una_llamada_nacional.costo).to eq 4.20 # dinero
    end
  end

  context 'cuando la llamada es a Europa' do
    it 'cuesta 70 centavos por minuto' do
      una_llamada_a_europa = Llamada.new(20,
                                         factory.numero_bsas,
                                         factory.numero_espanha)
      expect(una_llamada_a_europa.costo).to eq 14.00 # dinero
    end
  end

  context 'cuando la llamada es a Norte America' do
    it 'cuesta 70 centavos por minuto' do
      una_llamada_a_norte_america = Llamada.new(20,
                                                factory.numero_bsas,
                                                factory.numero_usa)
      expect(una_llamada_a_norte_america.costo).to eq 14.00 # dinero
    end
  end

  context 'cuando la llamada es a Sudamerica' do
    it 'cuesta 50 centavos por minuto' do
      una_llamada_a_sudamerica = Llamada.new(15,
                                             factory.numero_bsas,
                                             factory.numero_colombia)
      expect(una_llamada_a_sudamerica.costo).to eq 7.00 # dinero
    end
  end

end