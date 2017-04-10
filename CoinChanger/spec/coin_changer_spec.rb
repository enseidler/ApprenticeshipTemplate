require 'rspec'
require_relative '../lib/coin_changer'

describe CoinChanger do

  let(:coin_changer) {CoinChanger.new([1, 5, 10, 25, 50, 100])}

  context 'when input is 0' do
    it 'change should be 0 coins' do
      change = coin_changer.change_for(0)
      expected_change = {}

      expect(change).to eq(expected_change)
    end
  end

  context 'when input is 100' do
    it 'change should be 1 coin of 100' do
      change = coin_changer.change_for(100)
      expected_change = {100 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'cuando existe una moneda de igual denominacion que el input' do
    it 'el cambio deberia ser 1 moneda de dicha denominacion' do
      change = coin_changer.change_for(5)
      expected_change = {5 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'cuando el input es 1 mas que cualquier denominacion' do
    it 'el cambio deberia ser 1 moneda de dicha denominacion y otra de 1' do
      change = coin_changer.change_for(6)
      expected_change = {5 => 1, 1 => 1}

      expect(change).to eq(expected_change)
    end
  end

  #Borrar
  context 'cuando el input es 11' do
    it 'el cambio deberia ser 1 moneda de 10 y otra de 1' do
      change = coin_changer.change_for(11)
      expected_change = {10 => 1, 1 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'cuando el input es 30' do
    it 'el cambio deberia ser 1 moneda de 25 y otra de 5' do
      change = coin_changer.change_for(30)
      expected_change = {25 => 1, 5 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'cuando el input es 125' do
    it 'el cambio deberia ser 1 moneda de 100 y otra de 25' do
      change = coin_changer.change_for(125)
      expected_change = {100 => 1, 25 => 1}

      expect(change).to eq(expected_change)
    end
  end

end