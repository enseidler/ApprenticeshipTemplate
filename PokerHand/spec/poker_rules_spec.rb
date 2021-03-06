require 'rspec'
require_relative '../lib/poker_rules'

describe 'Poker Rules' do

  let(:poker_rules) { PokerRules.new }

  context 'given a poker hand with highest card Ace' do
    a_poker_hand = ['8', '2', 'A', '5', '2']
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

  context 'given another poker hand with highest card King' do
    another_poker_hand = ['T', '3', '4', 'K', '8']
    it 'should return K when ask for highest card' do
      expect(poker_rules.highest_card(another_poker_hand)).to eq 'K'
    end
  end

  context 'given a poker hand with highest card Queen' do
    another_poker_hand = ['2', '6', '4', 'Q', '8']
    it 'should return Q when ask for highest card' do
      expect(poker_rules.highest_card(another_poker_hand)).to eq 'Q'
    end
  end

  context 'given any poker hand with highest card Queen in any order' do
    a_poker_hand = ['T', 'Q', '3', '5', '8']
    another_poker_hand = ['2', '5', '4', 'Q', 'T']
    it 'should return Q when ask for highest card' do
      expect(poker_rules.highest_card(a_poker_hand)).to eq 'Q'
      expect(poker_rules.highest_card(another_poker_hand)).to eq 'Q'
    end
  end

  context 'given a poker hand with highest card Jack' do
    another_poker_hand = ['T', '6', '4', 'J', '8']
    it 'should return J when ask for highest card' do
      expect(poker_rules.highest_card(another_poker_hand)).to eq 'J'
    end
  end

  context 'given a poker hand with highest card 10' do
    another_poker_hand = ['T', '6', '4', '2', '8']
    it 'should return T when ask for highest card' do
      expect(poker_rules.highest_card(another_poker_hand)).to eq 'T'
    end
  end

end