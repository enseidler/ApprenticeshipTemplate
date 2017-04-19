require 'rspec'
require_relative '../lib/card'


describe 'Poker Card' do

  context 'given an Ace card' do
    it 'should be better than King' do
      ace_card = Card.new('A')
      king_card = Card.new('K')

      actual = ace_card.better? king_card

      expect(actual).to be_truthy
    end
  end

end