package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan49 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 50;
    }

    public Boolean canRepresent(Integer number) {
        return number > 49;
    }

    public String convert(Integer number) {
        return "L";
    }

}
