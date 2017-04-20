require_relative '../lib/cart'

class Cashier

  @date_provider

  def initialize(a_date_provider)
    @total_sales = 0
    @sold_books = []
    @date_provider = a_date_provider
  end

  def checkout(a_cart, a_credit_card)
    verify_cart(a_cart)
    verify_card(a_credit_card)

    total = total_price(a_cart.books, a_cart.catalog)
    register_sale(a_cart, total)
    total
  end

  def verify_card(a_credit_card)
    if (a_credit_card.before? (@date_provider.todays_month_of_year))
      raise 'La tarjeta está vencida'
    end
  end

  def verify_cart(a_cart)
    if a_cart.empty?
      raise 'El carrito está vacío!'
    end
  end

  def register_sale(a_cart, total)
    increase_total_sales(total)
    register_sold_books(a_cart.books)
  end

  def register_sold_books(some_books)
    (@sold_books << some_books).flatten!
  end

  def increase_total_sales(an_amount)
    @total_sales += an_amount
  end

  def total_price(books, catalog)
    books.inject(0) { |total, a_book| total + catalog[a_book] }
  end

  def total_sales
    @total_sales
  end

  def sold_book?(a_book)
    @sold_books.include? a_book
  end

end