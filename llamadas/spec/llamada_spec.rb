require 'rspec'
require_relative '../lib/llamada'

describe 'Llamada' do

  it 'una llamada de 1 minuto cuesta 30 centavos' do
    expect(Llamada.new(1).costo).to eq 0.30 # dinero
  end

  it 'una llamada de 2 minuto cuesta 60 centavos' do
    expect(Llamada.new(2).costo).to eq 0.60 # dinero
  end

  it 'una llamada cuesta 30 centavos por minuto' do
    expect(Llamada.new(14).costo).to eq 4.20 # dinero
  end

end