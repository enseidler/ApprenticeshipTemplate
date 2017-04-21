package numbers;

import org.apache.commons.lang.StringUtils;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorBetween1And3 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 1;
    }

    public Boolean canRepresent(Integer number) {
        return number > 0;
    }

    public String convert(Integer number) {
        return "I";
    }

}
