package numbers;

import errors.ImposibleInRomanException;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversor {

    public String integerToRoman(Integer number) throws Exception {
        verifyNumber(number);
        if(number == 0)
            return "";
        AbstractRomanConversor conversor = RomanConversorPicker.conversorFor(number);
        return conversor.convert(number) + integerToRoman(number - conversor.representedNumber());
    }

    private void verifyNumber(Integer number) throws Exception {
       if(number < 0)
			throw new ImposibleInRomanException("Negative numbers cannot be represented in roman numerals!");
       if(number > 3999)
			throw new ImposibleInRomanException("Numbers greater than 3999 cannot be represented in roman numerals!");
	}

}
