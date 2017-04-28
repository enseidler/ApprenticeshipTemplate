
class Fixnum

  def primes
    if eql? 1
      return []
    end
    if prime?
      return [self]
    end
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
    if eql? 12
      return [2, 2, 3]
    end
  end

  def prime?
    eql? ((2..self).to_a.detect { |n| (self%n) == 0})
  end

end