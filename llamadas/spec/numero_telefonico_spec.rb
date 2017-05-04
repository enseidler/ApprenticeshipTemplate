require 'rspec'
require_relative '../lib/numero_telefonico'
require_relative '../lib/factory_de_numeros_telefonicos'

describe 'Numero Telefonico' do

  let(:factory) { FactoryDeNumerosTelefonicos.new }

  it 'cuando el codigo de pais pertenece a un pais de Sudamerica es un numero de Sudamerica' do
    expect(factory.numero_bsas.sudamerica?).to be_truthy
    expect(factory.numero_colombia.sudamerica?).to be_truthy
  end

  it 'cuando el codigo de pais pertenece a un pais de otra region que NO es Sudamerica entonces NO es un numero de Sudamerica' do
    expect(factory.numero_espanha.sudamerica?).to be_falsey
    expect(factory.numero_usa.sudamerica?).to be_falsey
  end

  it 'cuando el codigo de pais pertenece a un pais de Europa es un numero de Europa' do
    expect(factory.numero_espanha.europa?).to be_truthy
  end

  it 'cuando el codigo de pais pertenece a un pais de otra region que NO es Europa entonces NO es un numero de Europa' do
    expect(factory.numero_bsas.europa?).to be_falsey
    expect(factory.numero_usa.europa?).to be_falsey
  end

  it 'cuando el codigo de pais pertenece a un pais de Norte America es un numero de Norte America' do
    expect(factory.numero_usa.norte_america?).to be_truthy
  end

  it 'cuando el codigo de pais pertenece a un pais de otra region que NO es Norte America entonces NO es un numero de Norte America' do
    expect(factory.numero_espanha.norte_america?).to be_falsey
    expect(factory.numero_colombia.norte_america?).to be_falsey
  end

end