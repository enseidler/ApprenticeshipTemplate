require 'rspec'
require_relative '../lib/coin_changer'


describe CoinChanger do

  let(:coin_changer) { CoinChanger.new([1, 5, 10, 25, 50, 100]) }

  def change_for_input_should_be(input, expected_change)
    change = coin_changer.change_for(input)
    expect(change).to eq(expected_change)
  end


  context 'when input is 0' do
    it 'change should be 0 coins' do
      change_for_input_should_be(0, {})
    end
  end

  context 'when input is 100' do
    it 'change should be 1 coin of 100' do
      change_for_input_should_be(100, {100 => 1})
    end
  end

  context 'when exists 1 coin with equal denomination that input' do
    it 'change should be 1 coin of this denomination' do
      change_for_input_should_be(5, {5 => 1})
    end
  end

  context 'when input is 1 more than any denomination' do
    it 'change should be 1 coin of this denomination and another of 1' do
      change_for_input_should_be(6, {5 => 1, 1 => 1})
    end
  end

  #ToDo borrar
  context 'when input is 30' do
    it 'change should be 1 coin of 25 and another of 5' do
      change_for_input_should_be(30, {25 => 1, 5 => 1})
    end
  end

  #ToDo borrar
  context 'when input is 125' do
    it 'change should be 1 coin of 100 and another of 25' do
      change_for_input_should_be(125, {100 => 1, 25 => 1})
    end
  end

  #ToDo borrar
  context 'when input is 200' do
    it 'change should be 2 coin of 100' do
      change_for_input_should_be(200, {100 => 2})
    end
  end

  #ToDo borrar ?
  context 'when input is a given N' do
    it 'change should minimum combination of coins' do
      change_for_input_should_be(3387, {100 => 33, 50 => 1, 25 => 1, 10 => 1, 1 => 2})
    end
  end

  context 'when input is negative' do
    it 'should raise an Invalid Input error' do
      expect{coin_changer.change_for(-1)}.to raise_error('Invalid Input! Should be positive.')
    end
  end

end