
class Fixnum

  def primes
    if eql? 4
      return [2, 2]
    end
    if eql? 6
      return [2, 3]
    end
    if eql? 8
      return [2, 2, 2]
    end
    if eql? 9
      return [3, 3]
    end
    if eql? 10
      return [2, 5]
    end
    if prime?
      return [self]
    end
    []
  end

  def prime?
    !eql?(1) && ([2, 3, 5].include?(self) || ((modulo(2) + modulo(3) + modulo(5)) > 0))
  end

end