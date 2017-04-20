
class MonthOfYear

  def initialize(a_month, a_year)
    verify_month(a_month)
    @month = a_month
    @year = a_year
  end


  def month
    @month
  end

  def year
    @year
  end

  def verify_month(a_month)
    if !a_month.between?(1, 12)
      raise 'Mes invalido'
    end
  end

  def self.today
    today = Date.today
    self.new(today.month, today.year)
  end

  def before?(other_month_of_year)
    month_before_same_year?(other_month_of_year) || year_before?(other_month_of_year)
  end

  def month_before_same_year?(other_month_of_year)
    month_before?(other_month_of_year) && same_year?(other_month_of_year)
  end

  def year_before?(other_month_of_year)
    @year < other_month_of_year.year
  end

  def same_year?(other_month_of_year)
    @year == other_month_of_year.year
  end

  def month_before?(other_month_of_year)
    @month < other_month_of_year.month
  end

end