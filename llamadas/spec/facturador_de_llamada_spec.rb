require 'rspec'
require 'time'
require_relative '../lib/llamada'
require_relative '../lib/factory_llamadas'
require_relative '../lib/facturador_de_llamada'

describe 'Facturador de Llamada' do

  let(:factory) { FactoryLlamadas.new }
  let(:facturador_de_llamada) { FacturadorDeLlamada.new }

  context 'cuando la llamada es nacional' do
    it 'cuesta 30 centavos por minuto' do
      una_llamada_nacional = Llamada.new(factory.un_intervalo_de_10_minutos,
                                         factory.numero_bsas,
                                         factory.numero_argentina)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_nacional)).to eq 3.00 # dinero
    end
  end

  context 'cuando la llamada es internacional' do
    it 'cuesta 70 centavos el minuto a Europa' do
      una_llamada_a_europa = Llamada.new(factory.un_intervalo_de_10_minutos,
                                         factory.numero_bsas,
                                         factory.numero_espanha)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_europa)).to eq 7.00 # dinero
    end

    it 'cuesta 70 centavos el minuto a Norte America' do
      una_llamada_a_norte_america = Llamada.new(factory.un_intervalo_de_10_minutos,
                                                factory.numero_bsas,
                                                factory.numero_usa)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_norte_america)).to eq 7.00 # dinero
    end

    it 'cuesta 50 centavos el minuto a Sudamerica' do
      una_llamada_a_sudamerica = Llamada.new(factory.un_intervalo_de_10_minutos,
                                             factory.numero_bsas,
                                             factory.numero_colombia)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_sudamerica)).to eq 5.00 # dinero
    end

    it 'cuesta 1.50 pesos el minuto a el resto del mundo' do
      una_llamada_a_asia = Llamada.new(factory.un_intervalo_de_10_minutos,
                                       factory.numero_bsas,
                                       factory.numero_china)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_a_asia)).to eq 15.00 # dinero
    end
  end

  context 'cuando la llamada es local' do
    it 'cuesta 10 centavos el minuto en fin de semana' do
      una_llamada_local_de_fin_de_semana = Llamada.new(factory.un_intervalo_de_fin_de_semana_de_30_minutos,
                                                       factory.numero_bsas,
                                                       factory.numero_bsas)
      expect(facturador_de_llamada.costo_de_llamada(una_llamada_local_de_fin_de_semana)).to eq 3.00 # dinero
    end
  end

end