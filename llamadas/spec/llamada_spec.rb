require 'rspec'
require_relative '../lib/llamada'

describe 'Llamada' do

  it 'una llamada de 1 minuto cuesta 30 centavos' do
    expect(Llamada.new(1).costo).to eq 0.30 # dinero
  end

end