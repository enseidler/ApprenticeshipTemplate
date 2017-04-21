class MerchantProcessorSimulator

  def initialize(&a_block)
    @block = a_block
  end

  def debit_from(an_amount, a_valid_card)
    @block.call
  end

end