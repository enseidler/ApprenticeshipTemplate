package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan399 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 400;
    }

    public Boolean canRepresent(Integer number) {
        return number > 399;
    }

    public String convert(Integer number) {
        return "CD";
    }

}
