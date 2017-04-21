package numbers;

/**
 * Created by ezequiel on 17/04/17.
 */
public abstract class AbstractRomanConversor {

    public abstract Integer representedNumber();

    public abstract Boolean canRepresent(Integer number);

    public abstract String convert(Integer number);

}
