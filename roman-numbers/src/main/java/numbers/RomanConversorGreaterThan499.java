package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan499 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 500;
    }

    public Boolean canRepresent(Integer number) {
        return number > 499;
    }

    public String convert(Integer number) {
        return "D";
    }

}
