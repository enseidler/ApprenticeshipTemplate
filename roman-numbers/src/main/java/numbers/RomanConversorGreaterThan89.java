package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan89 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 90;
    }

    public Boolean canRepresent(Integer number) {
        return number > 89;
    }

    public String convert(Integer number) {
        return "XC";
    }

}
