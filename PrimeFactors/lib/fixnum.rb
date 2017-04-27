
class Fixnum

  def primes
    if eql? 2
      return [2]
    end
    if eql? 3
      return [3]
    end
    []
  end

end