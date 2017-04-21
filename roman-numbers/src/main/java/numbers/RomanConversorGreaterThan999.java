package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan999 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 1000;
    }

    public Boolean canRepresent(Integer number) {
        return number > 999;
    }

    public String convert(Integer number) {
        return "M";
    }

}
