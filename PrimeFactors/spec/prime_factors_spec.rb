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

  it 'prime factors for 9 return 3 3' do
    expect(9.primes).to eq [3, 3]
  end

  it 'prime factors for 10 return 2 5' do
    expect(10.primes).to eq [2, 5]
  end

  it 'prime factors for 11 return 11' do
    expect(11.primes).to eq [11]
  end

  it 'prime factors for prime number return only the same number' do
    expect(37.primes).to eq [37]
    expect(163.primes).to eq [163]
    expect(683.primes).to eq [683]
  end

end