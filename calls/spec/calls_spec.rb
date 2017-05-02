require 'rspec'
require_relative '../lib/phone_biller'

describe 'Phone Biller' do

  let(:phone_biller) { PhoneBiller.new }

  context 'cuando la llamada es nacional' do
    it '1 minuto cuesta 30 centavos' do
      a_national_call = 1
      expect(phone_biller.call_cost(a_national_call)).to eq 0.30
    end

    it '2 minutos cuestan 60 centavos' do
      a_national_call = 2
      expect(phone_biller.call_cost(a_national_call)).to eq 0.60
    end
  end

end