require 'rspec'
require 'require_all'
require_relative '../lib/book_store_factory'

describe 'Cart' do

  let(:factory) { BookStoreFactory.new }

  context 'Cuando se crea un carrito' do
    it 'Debe estar vacío' do
      expect(factory.cart.empty?).to be_truthy
    end
  end

  context 'Cuando se agrega un libro a un carrito vacio' do
    it 'Ya no debe estar vacío y debe contener el libro agregado' do
      a_book = 'Rayuela'
      factory.cart.add(a_book)
      expect(factory.cart.empty?).to be_falsey
      expect(factory.cart.include? a_book).to be_truthy
    end
  end

  context 'Cuando se agregan dos libros a un carrito' do
    it 'Debe contener ambos libros' do
      a_book = 'Rayuela'
      another_book = 'Harry Potter'
      factory.cart.add(a_book)
      factory.cart.add(another_book)
      expect(factory.cart.include?a_book).to be_truthy
      expect(factory.cart.include?another_book).to be_truthy
    end
  end

  context 'Cuando se agregan dos ejemplares del mismo libro a un carrito' do
    it 'Debe contener el mismo libro 2 veces' do
      a_book = 'Rayuela'
      factory.cart.add(a_book)
      factory.cart.add(a_book)
      expect(factory.cart.how_many_of? a_book).to eq(2)
    end
  end

  context 'Cuando se intenta agregar un libro que no esta en el catalogo' do
    it 'Debe ocurrir un error' do
      not_on_catalog_book = 'Lord Of The Ring'
      expect{factory.cart.add(not_on_catalog_book)}.to raise_error('El libro no está en el catálogo!')
    end
  end

end