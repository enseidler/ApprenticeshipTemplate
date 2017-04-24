
class PokerRules

  def initialize
    @card_values = ['A', 'K', 'Q', 'J', 'T']
  end

  def highest_card(a_poker_hand)
    @card_values.detect { |card| a_poker_hand.include? card }
  end

end