package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorFor9 extends AbstractRomanConversor {

    public Integer representedNumber() {
        return 9;
    }

    public Boolean canRepresent(Integer number) {
        return number == 9;
    }

    public String convert(Integer number) {
        return "IX";
    }

}
