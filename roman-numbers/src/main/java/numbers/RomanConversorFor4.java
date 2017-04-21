package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorFor4 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 4;
    }

    public Boolean canRepresent(Integer number) {
        return number == 4;
    }

    public String convert(Integer number) {
        return "IV";
    }

}
