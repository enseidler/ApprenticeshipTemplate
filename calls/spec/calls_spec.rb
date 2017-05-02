require 'rspec'
require_relative '../lib/phone_biller'

describe 'Phone Biller' do

  it 'una llamada nacional de 1 minuto cuesta 30 centavos' do
    phone_biller = PhoneBiller.new;
    a_local_call = 1
    expect(phone_biller.call_cost(a_local_call)).to eq 0.30
  end

end