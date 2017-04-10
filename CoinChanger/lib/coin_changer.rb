class CoinChanger

  def initialize(coin_denominations)
    @coin_denominations = coin_denominations
  end

  def change_for(input)
    if(@coin_denominations.include? input)
      {input => 1}
    elsif(input == 0)
      {}
    else
      denomination = correct_denomination(input)
      {input - denomination => 1, denomination => 1}
    end
  end

  def correct_denomination(input)
    @coin_denominations.detect { |denomination|
      @coin_denominations.include? input - denomination
    }
  end

end