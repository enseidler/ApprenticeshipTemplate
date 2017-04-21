package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan899 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 900;
    }

    public Boolean canRepresent(Integer number) {
        return number > 899;
    }

    public String convert(Integer number) {
        return "CM";
    }

}
