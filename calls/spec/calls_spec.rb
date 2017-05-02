require 'rspec'
require_relative '../lib/phone_biller'

describe 'Phone Biller' do

  let(:phone_biller) { PhoneBiller.new }

  context 'cuando la llamada es nacional' do
    it 'cuesta 30 centavos por cada minuto' do
      a_national_call = 15
      expect(phone_biller.call_cost(a_national_call)).to eq 4.50
    end
  end

end