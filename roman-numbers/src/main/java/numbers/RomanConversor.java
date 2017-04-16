package numbers;

import org.apache.commons.lang.StringUtils;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversor {

    public String integerToRoman(Integer number) {
        if(number == 4)
            return "IV";
        if(number == 9)
            return "IX";
        if(number == 100)
            return "C";
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

}
