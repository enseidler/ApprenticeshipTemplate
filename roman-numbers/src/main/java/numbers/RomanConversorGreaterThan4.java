package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan4 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 5;
    }

    public Boolean canRepresent(Integer number) {
        return number > 4;
    }

    public String convert(Integer number) {
        return "V";
    }

}
