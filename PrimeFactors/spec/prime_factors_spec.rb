require 'rspec'
require_relative '../lib/fixnum'

describe 'PrimeFactors' do

  it 'for 1 return an empty list' do
    expect(1.primes).to eq []
  end

end