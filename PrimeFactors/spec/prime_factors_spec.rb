require 'rspec'
require_relative '../lib/fixnum'

describe 'PrimeFactors' do

  it 'for 1 return an empty list' do
    expect(1.primes).to eq []
  end

  it 'for 2 return 2' do
    expect(2.primes).to eq [2]
  end

end