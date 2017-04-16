package numbers;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import errors.ImposibleInRomanException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ezequiel on 11/04/17.
 */
public class RomanConversorTest {

	private RomanConversor conversor;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
    @Before
    public void setUp() {
        conversor = new RomanConversor();
    }


    public void conversionFromIntegerToRomanShouldBe(Integer number, String roman_expected) throws Exception {
        String actual = conversor.integerToRoman(number);
        String expected = roman_expected;

        assertEquals(expected, actual);
    }


    @Test
    public void conversionFrom1ToRomanShouldBeI() throws Exception{
        conversionFromIntegerToRomanShouldBe(1, "I");
    }

    @Test
    public void conversionFrom2ToRomanShouldBeII() throws Exception{
        conversionFromIntegerToRomanShouldBe(2, "II");
    }

    @Test
    public void conversionFrom3ToRomanShouldBeIII() throws Exception {
        conversionFromIntegerToRomanShouldBe(3, "III");
    }

    @Test
    public void conversionFrom4ToRomanShouldBeIV() throws Exception {
        conversionFromIntegerToRomanShouldBe(4, "IV");
    }

    @Test
    public void conversionFrom5ToRomanShouldBeV() throws Exception {
        conversionFromIntegerToRomanShouldBe(5, "V");
    }

    @Test
    public void conversionFrom6ToRomanShouldBeVI() throws Exception {
        conversionFromIntegerToRomanShouldBe(6, "VI");
    }

    @Test
    public void conversionFrom7ToRomanShouldBeVII() throws Exception {
        conversionFromIntegerToRomanShouldBe(7, "VII");
    }

    @Test
    public void conversionFrom8ToRomanShouldBeVIII() throws Exception {
        conversionFromIntegerToRomanShouldBe(8, "VIII");
    }

    @Test
    public void conversionFrom9ToRomanShouldBeIX() throws Exception {
        conversionFromIntegerToRomanShouldBe(9, "IX");
    }

    @Test
    public void conversionFrom10ToRomanShouldBeX() throws Exception {
        conversionFromIntegerToRomanShouldBe(10, "X");
    }

    @Test
    public void conversionFrom11ToRomanShouldBeXI() throws Exception {
        conversionFromIntegerToRomanShouldBe(11, "XI");
    }

    @Test
    public void conversionFrom12ToRomanShouldBeXII() throws Exception {
        conversionFromIntegerToRomanShouldBe(12, "XII");
    }

    @Test
    public void conversionFrom13ToRomanShouldBeXIII() throws Exception {
        conversionFromIntegerToRomanShouldBe(13, "XIII");
    }

    @Test
    public void conversionFrom14ToRomanShouldBeXIV() throws Exception {
        conversionFromIntegerToRomanShouldBe(14, "XIV");
    }

    @Test
    public void conversionFrom15ToRomanShouldBeXV() throws Exception {
        conversionFromIntegerToRomanShouldBe(15, "XV");
    }

    @Test
    public void conversionFrom40ToRomanShouldBeXL() throws Exception {
        conversionFromIntegerToRomanShouldBe(40, "XL");
    }

    @Test
    public void conversionFrom41ToRomanShouldBeXLI() throws Exception {
        conversionFromIntegerToRomanShouldBe(41, "XLI");
    }

    @Test
    public void conversionFrom50ToRomanShouldBeL() throws Exception {
        conversionFromIntegerToRomanShouldBe(50, "L");
    }
    
    @Test
    public void conversionFrom51ToRomanShouldBeLI() throws Exception {
        conversionFromIntegerToRomanShouldBe(51, "LI");
    }
    
    @Test
    public void conversionFrom90ToRomanShouldBeXC() throws Exception {
        conversionFromIntegerToRomanShouldBe(90, "XC");
    }
    
    @Test
    public void conversionFrom91ToRomanShouldBeXCI() throws Exception {
        conversionFromIntegerToRomanShouldBe(91, "XCI");
    }
    
    @Test
    public void conversionFrom100ToRomanShouldBeC() throws Exception {
        conversionFromIntegerToRomanShouldBe(100, "C");
    }

    @Test
    public void conversionFrom101ToRomanShouldBeCI() throws Exception {
        conversionFromIntegerToRomanShouldBe(101, "CI");
    }
    
    @Test
    public void conversionFrom400ToRomanShouldBeCD() throws Exception {
        conversionFromIntegerToRomanShouldBe(400, "CD");
    }
    
    @Test
    public void conversionFrom401ToRomanShouldBeCDI() throws Exception {
        conversionFromIntegerToRomanShouldBe(401, "CDI");
    }
    
    @Test
    public void conversionFrom500ToRomanShouldBeD() throws Exception {
        conversionFromIntegerToRomanShouldBe(500, "D");
    }
    
    @Test
    public void conversionFrom501ToRomanShouldBeDI() throws Exception {
        conversionFromIntegerToRomanShouldBe(501, "DI");
    }
    
    @Test
    public void conversionFrom900ToRomanShouldBeCM() throws Exception {
        conversionFromIntegerToRomanShouldBe(900, "CM");
    }
    
    @Test
    public void conversionFrom901ToRomanShouldBeCMI() throws Exception {
        conversionFromIntegerToRomanShouldBe(901, "CMI");
    }
    
    @Test
    public void conversionFrom1000ToRomanShouldBeM() throws Exception {
        conversionFromIntegerToRomanShouldBe(1000, "M");
    }
    
    @Test
    public void conversionFrom1001ToRomanShouldBeMI() throws Exception {
        conversionFromIntegerToRomanShouldBe(1001, "MI");
    }
    
    @Test
    public void conversionFromNegativeNumberToRomanShouldRaiseImposibleInRomanException() throws Exception {
    	expectedException.expect(ImposibleInRomanException.class);
    	expectedException.expectMessage("Negative numbers cannot be represented in roman numerals!");
    	conversor.integerToRoman(-1);
    }
    
}
