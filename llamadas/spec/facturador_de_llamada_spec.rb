require 'rspec'
require_relative '../lib/llamada'
require_relative '../lib/factory_de_numeros_telefonicos'
require_relative '../lib/facturador_de_llamada'

describe 'Facturador de Llamada' do

  let(:factory) { FactoryDeNumerosTelefonicos.new }
  let(:facturador_de_llamada) { FacturadorDeLlamada.new }

  context 'cuando la llamada es nacional' do
    it 'cuesta 30 centavos por minuto' do
      una_llamada_nacional = Llamada.new(14,
                                         factory.numero_bsas,
                                         factory.numero_argentina)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_nacional)).to eq 4.20 # dinero
    end
  end

  context 'cuando la llamada es internacional' do
    it 'cuesta 70 centavos el minuto a Europa' do
      una_llamada_a_europa = Llamada.new(20,
                                         factory.numero_bsas,
                                         factory.numero_espanha)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_europa)).to eq 14.00 # dinero
    end

    it 'cuesta 70 centavos el minuto a Norte America' do
      una_llamada_a_norte_america = Llamada.new(20,
                                                factory.numero_bsas,
                                                factory.numero_usa)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_norte_america)).to eq 14.00 # dinero
    end

    it 'cuesta 50 centavos el minuto a Sudamerica' do
      una_llamada_a_sudamerica = Llamada.new(15,
                                             factory.numero_bsas,
                                             factory.numero_colombia)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_sudamerica)).to eq 7.50 # dinero
    end

    it 'cuesta 1.50 pesos el minuto a el resto del mundo' do
      una_llamada_a_asia = Llamada.new(10,
                                       factory.numero_bsas,
                                       factory.numero_china)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_asia)).to eq 15.00 # dinero
    end
  end

end