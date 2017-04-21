require_relative '../lib/cart'

class TusLibrosInterface

  def initialize(some_users, a_catalog)
    @users = some_users
    @carts = {}
    @catalog = a_catalog
    @current_id = 1
  end

  def create_cart(a_user, a_password)
    verify_user_existance(a_user)
    verify_user_password(a_password, a_user)
    cart_ID = @current_id
    @current_id += 1
    @carts[cart_ID] = Cart.new(@catalog)
    cart_ID
  end

  def verify_user_existance(a_user)
    if !@users.include? a_user
      raise 'El usuario no existe'
    end
  end

  def verify_user_password(a_password, a_user)
    if @users[a_user] != a_password
      raise 'Contraseña incorrecta'
    end
  end

  def exists_cart?(an_ID)
    return @carts.include? an_ID
  end

end