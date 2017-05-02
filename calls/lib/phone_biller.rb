
class PhoneBiller

  def call_cost(a_national_call)
    if a_national_call.eql? 2
      return 0.60
    end
    0.30
  end

end