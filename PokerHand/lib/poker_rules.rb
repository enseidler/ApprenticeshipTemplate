class PokerRules

  def highest_card(a_poker_hand)
    if a_poker_hand.include? 'K'
      return 'K'
    end
    if a_poker_hand.include? 'Q'
      return 'Q'
    end
    if a_poker_hand.include? 'J'
      return 'J'
    end
    'A'
  end

end