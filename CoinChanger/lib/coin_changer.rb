class CoinChanger

  def initialize(coin_denominations)
    @coin_denominations = coin_denominations.sort.reverse
  end

  def change_for(input)
    current_input = input
    change = {}
    @coin_denominations.each { |denomination|
      number_of_coins = current_input/denomination.to_i
      if(number_of_coins > 0)
        change[denomination] = number_of_coins
        current_input -= number_of_coins*denomination
      end
    }
    change
  end

  def correct_denomination(input)
    @coin_denominations.detect { |denomination|
      @coin_denominations.include? input - denomination
    }
  end

end