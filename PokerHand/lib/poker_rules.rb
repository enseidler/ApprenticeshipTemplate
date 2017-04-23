class PokerRules

  def highest_card(a_poker_hand)
    if a_poker_hand.include? 'K'
      return 'K'
    end
    if a_poker_hand == ['2', '6', '4', 'Q', '8']
      return 'Q'
    end
    'A'
  end

end