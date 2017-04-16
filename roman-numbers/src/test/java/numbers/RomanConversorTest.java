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

    @Test
    public void conversionFrom5ToRomanShouldBeV() {
        conversionFromIntegerToRomanShouldBe(5, "V");
    }

    @Test
    public void conversionFrom6ToRomanShouldBeVI() {
        conversionFromIntegerToRomanShouldBe(6, "VI");
    }

    @Test
    public void conversionFrom7ToRomanShouldBeVII() {
        conversionFromIntegerToRomanShouldBe(7, "VII");
    }

    @Test
    public void conversionFrom8ToRomanShouldBeVIII() {
        conversionFromIntegerToRomanShouldBe(8, "VIII");
    }

    @Test
    public void conversionFrom9ToRomanShouldBeIX() {
        conversionFromIntegerToRomanShouldBe(9, "IX");
    }

    @Test
    public void conversionFrom10ToRomanShouldBeX() {
        conversionFromIntegerToRomanShouldBe(10, "X");
    }

    @Test
    public void conversionFrom11ToRomanShouldBeXI() {
        conversionFromIntegerToRomanShouldBe(11, "XI");
    }

    @Test
    public void conversionFrom12ToRomanShouldBeXII() {
        conversionFromIntegerToRomanShouldBe(12, "XII");
    }

    @Test
    public void conversionFrom13ToRomanShouldBeXIII() {
        conversionFromIntegerToRomanShouldBe(13, "XIII");
    }

    @Test
    public void conversionFrom14ToRomanShouldBeXIV() {
        conversionFromIntegerToRomanShouldBe(14, "XIV");
    }

    @Test
    public void conversionFrom15ToRomanShouldBeXV() {
        conversionFromIntegerToRomanShouldBe(15, "XV");
    }

    @Test
    public void conversionFrom40ToRomanShouldBeXL() {
        conversionFromIntegerToRomanShouldBe(40, "XL");
    }

    @Test
    public void conversionFrom41ToRomanShouldBeXLI() {
        conversionFromIntegerToRomanShouldBe(41, "XLI");
    }

    @Test
    public void conversionFrom50ToRomanShouldBeL() {
        conversionFromIntegerToRomanShouldBe(50, "L");
    }
    
    @Test
    public void conversionFrom51ToRomanShouldBeLI() {
        conversionFromIntegerToRomanShouldBe(51, "LI");
    }
    
    @Test
    public void conversionFrom90ToRomanShouldBeXC() {
        conversionFromIntegerToRomanShouldBe(90, "XC");
    }
    
    @Test
    public void conversionFrom91ToRomanShouldBeXCI() {
        conversionFromIntegerToRomanShouldBe(91, "XCI");
    }
    
    @Test
    public void conversionFrom100ToRomanShouldBeC() {
        conversionFromIntegerToRomanShouldBe(100, "C");
    }

    @Test
    public void conversionFrom101ToRomanShouldBeCI() {
        conversionFromIntegerToRomanShouldBe(101, "CI");
    }
    
    @Test
    public void conversionFrom400ToRomanShouldBeCD() {
        conversionFromIntegerToRomanShouldBe(400, "CD");
    }
    
    @Test
    public void conversionFrom401ToRomanShouldBeCDI() {
        conversionFromIntegerToRomanShouldBe(401, "CDI");
    }
    
    @Test
    public void conversionFrom500ToRomanShouldBeD() {
        conversionFromIntegerToRomanShouldBe(500, "D");
    }
    
    @Test
    public void conversionFrom501ToRomanShouldBeDI() {
        conversionFromIntegerToRomanShouldBe(501, "DI");
    }
    
    @Test
    public void conversionFrom900ToRomanShouldBeCM() {
        conversionFromIntegerToRomanShouldBe(900, "CM");
    }
    
}
