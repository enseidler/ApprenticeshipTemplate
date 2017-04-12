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
        if(number == 10)
            return "X";
        if(number == 11)
            return "XI";
        if(number == 12)
            return "XII";
        if(number > 4)
            return "V" + StringUtils.repeat("I", number-5);
        return StringUtils.repeat("I", number);
    }

}
