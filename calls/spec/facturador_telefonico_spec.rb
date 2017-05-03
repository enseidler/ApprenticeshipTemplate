require 'rspec'
require 'time'
require_relative '../lib/facturador_telefonico'
require_relative '../lib/llamada'

describe 'Facturador Telefonico' do

  let(:facturador) { FacturadorTelefonico.new }

  context 'cuando la llamada es nacional' do
    it 'cuesta 30 centavos por cada minuto' do
      una_llamada_nacional = Llamada.new(Range.new(
          Time.new(2017, 4, 27, 17, 00),
          Time.new(2017, 4, 27, 17, 15)),
          'un_numero_telefonico',
          'otro_numero_telefonico')
      expect(facturador.costo_de_llamada(una_llamada_nacional)).to eq 4.50 # dinero
    end
  end

  context 'cuando la llamada es local y un dia sabado' do
    it '1 minuto cuesta 10 centavos' do
      una_llamada_de_sabado = Llamada.new(Range.new(
          Time.new(2017, 4, 29, 12, 00),
          Time.new(2017, 4, 29, 12, 01)),
          'un_numero_telefonico',
          'otro_numero_telefonico')
      expect(facturador.costo_de_llamada(una_llamada_de_sabado)).to eq 0.10 # dinero
    end
  end

end