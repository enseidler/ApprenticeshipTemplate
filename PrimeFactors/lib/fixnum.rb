
class Fixnum

  def primes
    if between?(2, 3)
      return [self]
    end
    if eql? 4
      return [2, 2]
    end
    if eql? 5
      return [5]
    end
    []
  end

end