package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan99 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 100;
    }

    public Boolean canRepresent(Integer number) {
        return number > 99;
    }

    public String convert(Integer number) {
        return "C";
    }

}
