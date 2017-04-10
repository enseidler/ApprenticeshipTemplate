require 'rspec'
require_relative '../lib/coin_changer'

describe CoinChanger do

  let(:coin_changer) { CoinChanger.new([1, 5, 10, 25, 50, 100]) }

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

  context 'when exists 1 coin with equal denomination that input' do
    it 'change should be 1 coin of this denomination' do
      change = coin_changer.change_for(5)
      expected_change = {5 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'when input is 1 more than any denomination' do
    it 'change should be 1 coin of this denomination and another of 1' do
      change = coin_changer.change_for(6)
      expected_change = {5 => 1, 1 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'when input is 30' do
    it 'change should be 1 coin of 25 and another of 5' do
      change = coin_changer.change_for(30)
      expected_change = {25 => 1, 5 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'when input is 125' do
    it 'change should be 1 coin of 100 and another of 25' do
      change = coin_changer.change_for(125)
      expected_change = {100 => 1, 25 => 1}

      expect(change).to eq(expected_change)
    end
  end

  context 'when input is 200' do
    it 'change should be 2 coin of 100' do
      change = coin_changer.change_for(200)
      expected_change = {100 => 2}

      expect(change).to eq(expected_change)
    end
  end

  #Borrar?
  context 'when input is a given N' do
    it 'change should minimum combination of coins' do
      change = coin_changer.change_for(3387)
      expected_change = {100 => 33, 50 => 1, 25 => 1, 10 => 1, 1 => 2}

      expect(change).to eq(expected_change)
    end
  end

  context 'when input is negative' do
    it 'should raise an Invalid Input error' do
      expect{coin_changer.change_for(-1)}.to raise_error('Invalid input! Should be positive.')
    end
  end

end