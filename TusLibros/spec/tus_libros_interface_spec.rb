require 'rspec'
require 'require_all'
require_all 'lib'

describe 'Tus libros interface' do
  let(:factory) { BookStoreFactory.new }

  context 'Cuando se intenta crear un carrito para un usuario inexistente' do
    it 'Debe ocurrir un error' do
      expect{factory.interface.create_cart('non_user', 'password')}.to raise_error 'El usuario no existe'
    end
  end

  context 'Cuando se intenta crear un carrito para un usuario con una password incorrecta' do
    it 'Debe ocurrir un error' do
      expect{factory.interface.create_cart('user', 'incorrect_password')}.to raise_error 'Contraseña incorrecta'
    end
  end

  context 'Cuando se intenta un carrito para un usuario y contraseña validos' do
    it 'Debe asignar un carrito con ID único' do
      expect(factory.interface.create_cart('user', 'password')).to eq 1
      expect(factory.interface.exists_cart? 1).to be_truthy
    end
  end


end