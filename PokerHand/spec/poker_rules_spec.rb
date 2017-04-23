require 'rspec'
require_relative '../lib/poker_rules'

describe 'Poker Rules' do

  let(:poker_rules) { PokerRules.new }

  context 'given a poker hand with highest card Ace' do
    a_poker_hand = ['8', '2', 'A', '5', 'T']
    it 'should return A when ask for highest card' do
      expect(poker_rules.highest_card(a_poker_hand)).to eq 'A'
    end
  end

  context 'given a poker hand with highest card King' do
    a_poker_hand = ['K', '3', '4', '5', '8']
    it 'should return K when ask for highest card' do
      expect(poker_rules.highest_card(a_poker_hand)).to eq 'K'
    end
  end

end