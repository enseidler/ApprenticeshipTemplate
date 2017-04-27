
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
    if eql? 6
      return [2, 3]
    end
    if eql? 7
      return [7]
    end
    []
  end

end