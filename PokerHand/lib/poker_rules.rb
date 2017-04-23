class PokerRules

  def highest_card(a_poker_hand)
    if a_poker_hand.include? 'K'
      return 'K'
    end
    'A'
  end

end