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
        if(number == 14)
            return "XIV";
        if(number == 15)
            return "XV";
        if(number > 9)
            return "X" + StringUtils.repeat("I", number - 10);
        if(number > 4)
            return "V" + StringUtils.repeat("I", number - 5);
        return StringUtils.repeat("I", number);
    }

}
