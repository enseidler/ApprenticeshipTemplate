package fibonacci;

import fibonacci.errors.PosicionNegativaException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ezequiel on 05/04/17.
 */
public class FibonacciTest {


    public void laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(Integer posicion, Integer esperado) throws Exception {
        Integer resultado = Fibonacci.valorEnPosicion(posicion);
        assertEquals(resultado, esperado);
    }


    @Test
    public void laPosicion0EnSecuenciaDeFibonacciDeberiaRetornar0() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(0, 0);
    }

    @Test
    public void laPosicion1EnSecuenciaDeFibonacciDeberiaRetornar1() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(1, 1);
    }

    @Test
    public void laPosicion2EnSecuenciaDeFibonacciDeberiaRetornar1() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(2, 1);
    }

    @Test
    public void laPosicion3EnSecuenciaDeFibonacciDeberiaRetornar2() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(3, 2);
    }

    @Test
    public void laPosicion4EnSecuenciaDeFibonacciDeberiaRetornar3() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(4, 3);
    }

    @Test
    public void laPosicion5EnSecuenciaDeFibonacciDeberiaRetornar5() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(5, 5);
    }

    @Test
    public void laPosicion6EnSecuenciaDeFibonacciDeberiaRetornar8() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(6, 8);
    }

    @Test
    public void laPosicion7EnSecuenciaDeFibonacciDeberiaRetornar13() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(7, 13);
    }

    @Test
    public void laPosicion8EnSecuenciaDeFibonacciDeberiaRetornar21() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(8, 21);
    }

    @Test
    public void laPosicion9EnSecuenciaDeFibonacciDeberiaRetornar34() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(9, 34);
    }

    @Test
    public void posicionNEnSecuenciaDeFibonacciDeberiaSerLaSumaDelFibonacciDeLasDosAnteriores() throws Exception {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(17, 1597);
    }

    @Test(expected = PosicionNegativaException.class)
    public void cuandoLaPosicionEsUnNumeroNegativoDebeHaberError() throws Exception {
        Fibonacci.valorEnPosicion(-1);
    }
}
