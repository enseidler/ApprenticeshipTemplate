package numbers;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversorTest {

    private RomanConversor conversor;

    @Before
    public void setUp() {
        conversor = new RomanConversor();
    }


    public void conversionFromIntegerToRomanShouldBe(Integer number, String roman_expected) {
        String actual = conversor.integerToRoman(number);
        String expected = roman_expected;

        assertEquals(expected, actual);
    }


    @Test
    public void conversionFrom1ToRomanShouldBeI(){
        conversionFromIntegerToRomanShouldBe(1, "I");
    }

    @Test
    public void conversionFrom2ToRomanShouldBeII(){
        conversionFromIntegerToRomanShouldBe(2, "II");
    }

    @Test
    public void conversionFrom3ToRomanShouldBeIII() {
        conversionFromIntegerToRomanShouldBe(3, "III");
    }

    @Test
    public void conversionFrom4ToRomanShouldBeIV() {
        conversionFromIntegerToRomanShouldBe(4, "IV");
    }

}
