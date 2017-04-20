class Cart

  def initialize(catalog)
    @books = []
    @catalog = catalog
  end

  def catalog
    @catalog
  end

  def books
    @books
  end

  def empty?
    @books.empty?
  end

  def add(a_book)
    verify_on_catalog_for(a_book)
    @books << a_book
  end

  def include?(a_book)
    @books.include? a_book
  end

  def how_many_of?(a_book)
    @books.select{|each_book| each_book.eql? a_book}.length
  end

  def verify_on_catalog_for(a_book)
    if (!@catalog.include? a_book)
      raise('El libro no está en el catálogo!')
    end
  end

end
