require_relative '../lib/cart'
require_relative '../lib/../lib/date_provider_simulator'

class BookStoreFactory

  def initialize
    @cart = create_cart
    @cashier_with_merchant_processor_ok = create_cashier_with_merchant_processor_ok
    @cashier_with_merchant_processor_failer = create_cashier_with_merchant_processor_failer
    @valid_card = create_valid_card
    @interface = create_interface
  end

  def cashier_ok
    @cashier_with_merchant_processor_ok
  end

  def cashier_failer
    @cashier_with_merchant_processor_failer
  end

  def cart
    @cart
  end

  def valid_card
    @valid_card
  end

  def interface
    @interface
  end

  def create_valid_card
    MonthOfYear.new(5, 2017)
  end

  def create_cart
    Cart.new(catalog)
  end

  def catalog
    {'Rayuela' => 20, 'Harry Potter' => 50}
  end

  def create_cashier_with_merchant_processor_ok
    Cashier.new(create_date_provider, create_merchant_processor_ok)
  end

  def create_cashier_with_merchant_processor_failer
    Cashier.new(create_date_provider, create_merchant_processor_failer)
  end

  def create_date_provider
    DateProviderSimulator.new(MonthOfYear.new(4, 2017))
  end

  def create_merchant_processor_ok
    MerchantProcessorSimulator.new {}
  end

  def create_merchant_processor_failer
    MerchantProcessorSimulator.new {raise 'No se pudo efectuar el pago'}
  end

  def create_interface
    TusLibrosInterface.new({'user' => 'password'}, catalog)
  end

end