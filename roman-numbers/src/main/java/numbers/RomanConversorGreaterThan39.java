package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorGreaterThan39 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 40;
    }

    public Boolean canRepresent(Integer number) {
        return number > 39;
    }

    public String convert(Integer number) {
        return "XL";
    }

}
