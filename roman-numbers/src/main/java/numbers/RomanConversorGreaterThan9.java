package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan9 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 10;
    }

    public Boolean canRepresent(Integer number) {
        return number > 9;
    }

    public String convert(Integer number) {
        return "X";
    }

}
