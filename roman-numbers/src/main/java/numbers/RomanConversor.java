package numbers;

import org.apache.commons.lang.StringUtils;

import errors.ImposibleInRomanException;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversor {

    public String integerToRoman(Integer number) throws Exception {
    	verifyNumber(number);
    	
        if(number == 4)
            return "IV";
        if(number == 9)
            return "IX";
        if(number > 999)
            return "M" + integerToRoman(number - 1000);
        if(number > 899)
        	return "CM" + integerToRoman(number - 900);
        if(number > 499)
        	return "D" + integerToRoman(number - 500);
        if(number > 399)
        	return "CD" + integerToRoman(number - 400);
        if(number > 99)
            return "C" + integerToRoman(number - 100);
        if(number > 89)
        	return "XC" + integerToRoman(number - 90);
        if(number > 49)
            return "L" + integerToRoman(number - 50);
        if(number > 39)
            return "XL" + integerToRoman(number - 40);
        if(number > 9)
            return "X" + integerToRoman(number - 10);
        if(number > 4)
            return "V" + integerToRoman(number - 5);
        return StringUtils.repeat("I", number);
    }

	private void verifyNumber(Integer number) throws Exception {
		if(number < 0)
			throw new ImposibleInRomanException("Negative numbers cannot be represented in roman numerals!");
	}

}
