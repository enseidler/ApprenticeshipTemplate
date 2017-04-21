package numbers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ezequiel on 17/04/17.
 */
public class RomanConversorPicker {

    private static List<AbstractRomanConversor> romanConversors = Arrays.asList(
            new RomanConversorFor4(),
            new RomanConversorFor9(),
            new RomanConversorGreaterThan999(),
            new RomanConversorGreaterThan899(),
            new RomanConversorGreaterThan499(),
            new RomanConversorGreaterThan399(),
            new RomanConversorGreaterThan99(),
            new RomanConversorGreaterThan89(),
            new RomanConversorGreaterThan49(),
            new RomanConversorGreaterThan39(),
            new RomanConversorGreaterThan9(),
            new RomanConversorGreaterThan4(),
            new RomanConversorBetween1And3());

    public static AbstractRomanConversor conversorFor(Integer number) {
        for(AbstractRomanConversor conversor : romanConversors) {
            if(conversor.canRepresent(number))
                return conversor;
        }
        return new RomanConversorFor0();
    }

}
