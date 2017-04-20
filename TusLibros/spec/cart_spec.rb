require 'rspec'
require 'require_all'
require_all 'lib'

describe 'Cart' do

  let(:cart) { Cart.new(['Rayuela', 'Harry Potter']) }

  context 'Cuando se crea un carrito' do
    it 'Debe estar vacío' do
      expect(cart.empty?).to be_truthy
    end
  end

  context 'Cuando se agrega un libro a un carrito vacio' do
    it 'Ya no debe estar vacío y debe contener el libro agregado' do
      a_book = 'Rayuela'
      cart.add(a_book)
      expect(cart.empty?).to be_falsey
      expect(cart.include? a_book).to be_truthy
    end
  end

  context 'Cuando se agregan dos libros a un carrito' do
    it 'Debe contener ambos libros' do
      a_book = 'Rayuela'
      another_book = 'Harry Potter'
      cart.add(a_book)
      cart.add(another_book)
      expect(cart.include?a_book).to be_truthy
      expect(cart.include?another_book).to be_truthy
    end
  end

  context 'Cuando se agregan dos ejemplares del mismo libro a un carrito' do
    it 'Debe contener el mismo libro 2 veces' do
      a_book = 'Rayuela'
      cart.add(a_book)
      cart.add(a_book)
      expect(cart.how_many_of? a_book).to eq(2)
    end
  end

  context 'Cuando se intenta agregar un libro que no esta en el catalogo' do
    it 'Debe ocurrir un error' do
      not_on_catalog_book = 'Lord Of The Ring'
      expect{cart.add(not_on_catalog_book)}.to raise_error('El libro no está en el catálogo!')
    end
  end

end