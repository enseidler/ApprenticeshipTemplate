require 'rspec'
require_relative '../lib/llamada'

describe 'Llamada' do

  it 'cuando ambos numeros son de BSAS es llamada local' do
    una_llamada = Llamada.new(Range.new(Time.new(), Time.new() + 1),
                              '54 11 71648574',
                              '54 11 69563255')
    expect(una_llamada.nacional?).to be_truthy
  end

end