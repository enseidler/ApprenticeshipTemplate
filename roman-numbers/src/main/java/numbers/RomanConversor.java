package numbers;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversor {

    public String integerToRoman(Integer number) {
        if (number == 1)
            return "I";
        if (number == 2)
            return "II";
        if (number == 3)
            return "III";
        return "";
    }

}
