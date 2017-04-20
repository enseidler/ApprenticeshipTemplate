require_relative '../lib/cart'
require_relative '../lib/../lib/date_provider_simulator'

class BookStoreFactory

  def initialize
    @cart = create_cart
    @cashier = create_cashier
    @valid_card = create_valid_card
  end

  def cashier
    @cashier
  end

  def cart
    @cart
  end

  def valid_card
    @valid_card
  end

  def create_valid_card
    MonthOfYear.new(5, 2017)
  end

  def create_cart
    Cart.new({'Rayuela' => 20, 'Harry Potter' => 50})
  end

  def create_cashier
    Cashier.new(create_date_provider)
  end

  def create_date_provider
    DateProviderSimulator.new(MonthOfYear.new(4, 2017))
  end

end