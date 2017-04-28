require 'rspec'
require_relative '../lib/fixnum'

describe 'PrimeFactors' do

  it 'prime factors for 1 return an empty list' do
    expect(1.primes).to eq []
  end

  it 'prime factors for 2 return 2' do
    expect(2.primes).to eq [2]
  end

  it 'prime factors for 3 return 3' do
    expect(3.primes).to eq [3]
  end

  it 'prime factors for 4 return 2 2' do
    expect(4.primes).to eq [2, 2]
  end

  it 'prime factors for 5 return 5' do
    expect(5.primes).to eq [5]
  end

  it 'prime factors for 6 return 2 3' do
    expect(6.primes).to eq [2, 3]
  end

  it 'prime factors for 7 return 2 3' do
    expect(7.primes).to eq [7]
  end

  it 'prime factors for 8 return 2 2 2' do
    expect(8.primes).to eq [2, 2, 2]
  end

end