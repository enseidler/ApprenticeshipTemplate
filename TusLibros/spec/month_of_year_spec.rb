require 'rspec'
require_relative '../lib/month_of_year'

describe 'Month Of Year' do

  context 'Cuando se crea un mes de año con mes fuera del rango de los 12 meses' do
    it 'Debe dar un error' do
      expect{MonthOfYear.new(13,2017)}.to raise_error 'Mes invalido'
      expect{MonthOfYear.new(-1,2017)}.to raise_error 'Mes invalido'
    end
  end

  context 'Un MonthOfYear es anterior a otro' do
    it 'cuando el mes es anterior y el año es el mismo' do
      a_month_of_year = MonthOfYear.new(6, 2017)
      another_month_of_year = MonthOfYear.new(7, 2017)
      expect(a_month_of_year.before? another_month_of_year).to be_truthy
    end

    it 'cuando el año es el anterior' do
      a_month_of_year = MonthOfYear.new(7, 2012)
      another_month_of_year = MonthOfYear.new(3, 2014)
      expect(a_month_of_year.before? another_month_of_year).to be_truthy
    end
  end

  context 'Un MonthOfYear NO es anterior a otro' do
    it 'cuando el mes es posterior y el año es el mismo' do
      a_month_of_year = MonthOfYear.new(8, 2017)
      another_month_of_year = MonthOfYear.new(4, 2017)
      expect(a_month_of_year.before? another_month_of_year).to be_falsey
    end

    it 'cuando el año es el posterior' do
      a_month_of_year = MonthOfYear.new(6, 2017)
      another_month_of_year = MonthOfYear.new(12, 2015)
      expect(a_month_of_year.before? another_month_of_year).to be_falsey
    end
  end

end