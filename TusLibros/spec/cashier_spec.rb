require 'rspec'
require 'require_all'
require 'date'
require_all 'lib'

describe 'Cashier' do

  let(:factory) { BookStoreFactory.new }

  context 'Cuando se realiza el checkout de un carrito vacio' do
    it 'Debe ocurrir un error' do
      expect{factory.cashier_ok.checkout(factory.cart, factory.valid_card)}.to raise_error 'El carrito está vacío!'
    end
  end

  context 'Cuando se realiza el checkout de un carrito con un libro' do
    it 'El total de la venta debe ser el precio del libro' do
      factory.cart.add('Rayuela')
      expect(factory.cashier_ok.checkout(factory.cart, factory.valid_card)).to eq 20
    end
  end

  context 'Cuando se realiza el checkout de un carrito con más de un libro' do
    it 'El total de la venta debe ser el total de la suma de los precios de los libros' do
      factory.cart.add('Rayuela')
      factory.cart.add('Harry Potter')
      expect(factory.cashier_ok.checkout(factory.cart, factory.valid_card)).to eq 70
    end
  end

  context 'Cuando se realiza el checkout de un carrito' do
    it 'El total de ventas debe ser el total de la venta de ese carrito' do
      factory.cart.add('Rayuela')
      factory.cashier_ok.checkout(factory.cart, factory.valid_card)
      expect(factory.cashier_ok.total_sales()).to eq 20
    end

    it 'Se deben registrar los libros vendidos' do
      factory.cart.add('Harry Potter')
      factory.cashier_ok.checkout(factory.cart, factory.valid_card)
      expect(factory.cashier_ok.sold_book? 'Harry Potter').to be_truthy
      expect(factory.cashier_ok.sold_book? 'Rayuela').to be_falsey
    end
  end

  context 'Cuando se realiza el checkout de más de un carrito' do
    it 'El total de ventas debe ser el total de la suma de esas ventas' do
      factory.cart.add('Rayuela')
      another_cart = factory.create_cart
      another_cart.add('Harry Potter')
      factory.cashier_ok.checkout(factory.cart, factory.valid_card)
      factory.cashier_ok.checkout(another_cart, factory.valid_card)
      expect(factory.cashier_ok.total_sales).to eq 70
    end
  end

  context 'Cuando se quiere realizar el checkout de un carrito con una tarjeta vencida' do
    let(:invalid_card) { MonthOfYear.new(3, 2017) }
    it 'Debe ocurrir un error' do
      factory.cart.add('Rayuela')
      expect{factory.cashier_ok.checkout(factory.cart, invalid_card)}.to raise_error 'La tarjeta está vencida'
    end
  end

  context 'Cuando se debita de una tarjeta de crédito sin fondos' do
    it 'Debe ocurrir un error' do
      expect{factory.cashier_failer.debit_from(70, factory.valid_card)}.to raise_error 'No se pudo efectuar el pago'
    end
  end

  context 'Cuando se realiza un checkout con una tarjeta de crédito sin fondos' do
    it 'No se debe registrar la venta y debe ocurrir un error' do
      factory.cart.add('Rayuela')
      expect{factory.cashier_failer.checkout(factory.cart, factory.valid_card)}.to raise_error 'No se pudo efectuar el pago'
      expect(factory.cashier_failer.sold_book? 'Rayuela').to be_falsey
    end
  end

end
