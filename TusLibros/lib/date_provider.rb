require 'month_of_year'

class DateProvider

  def todays_month_of_year
    MonthOfYear.today
  end

end