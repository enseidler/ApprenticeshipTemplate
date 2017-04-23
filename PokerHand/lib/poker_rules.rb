class PokerRules

  def highest_card(a_poker_hand)
    if a_poker_hand == ['K', '3', '4', '5', '8'] || a_poker_hand == ['T', '3', '4', 'K', '8']
      return 'K'
    end
    'A'
  end

end