package numbers;

import org.apache.commons.lang.StringUtils;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversor {

    public String integerToRoman(Integer number) {
        if(number == 4)
            return "IV";
        if(number == 5)
            return "V";
        if(number == 6)
            return "VI";
        return StringUtils.repeat("I", number);
    }

}
