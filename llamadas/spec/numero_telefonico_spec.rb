require 'rspec'
require_relative '../lib/numero_telefonico'
require_relative '../lib/factory_de_numeros_telefonicos'

describe 'Numero Telefonico' do

  let(:factory) { FactoryDeNumerosTelefonicos.new }

  it 'cuando el codigo de pais partenece a un pais de sudamerica es un numero de sudamerica' do
    expect(factory.numero_bsas.sudamerica?).to be_truthy
    expect(factory.numero_colombia.sudamerica?).to be_truthy
  end

end