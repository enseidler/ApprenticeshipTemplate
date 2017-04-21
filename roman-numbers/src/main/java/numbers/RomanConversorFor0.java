package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorFor0 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 0;
    }

    public Boolean canRepresent(Integer number) {
        return number == 0;
    }

    public String convert(Integer number) {
        return "";
    }

}
