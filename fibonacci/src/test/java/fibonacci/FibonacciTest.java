package fibonacci;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ezequiel on 05/04/17.
 */
public class FibonacciTest {


    public void laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(Integer posicion, Integer esperado) {
        Integer resultado = Fibonacci.valorEnPosicion(posicion);
        assertEquals(resultado, esperado);
    }


    @Test
    public void laPosicion0EnSecuenciaDeFibonacciDeberiaRetornar0() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(0, 0);
    }

    @Test
    public void laPosicion1EnSecuenciaDeFibonacciDeberiaRetornar1() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(1, 1);
    }

    @Test
    public void laPosicion2EnSecuenciaDeFibonacciDeberiaRetornar1() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(2, 1);
    }

    @Test
    public void laPosicion3EnSecuenciaDeFibonacciDeberiaRetornar2() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(3, 2);
    }

    @Test
    public void laPosicion4EnSecuenciaDeFibonacciDeberiaRetornar3() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(4, 3);
    }

    @Test
    public void laPosicion5EnSecuenciaDeFibonacciDeberiaRetornar5() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(5, 5);
    }

    @Test
    public void laPosicion6EnSecuenciaDeFibonacciDeberiaRetornar8() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(6, 8);
    }

    @Test
    public void laPosicion7EnSecuenciaDeFibonacciDeberiaRetornar13() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(7, 13);
    }

    @Test
    public void laPosicion8EnSecuenciaDeFibonacciDeberiaRetornar21() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(8, 21);
    }

    @Test
    public void laPosicion9EnSecuenciaDeFibonacciDeberiaRetornar34() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(9, 34);
    }

    @Test
    public void laPosicion17EnSecuenciaDeFibonacciDeberiaRetornar1597() {
        laPosicionEnSecuenciaDeFibonacciDeberiaRetornar(17, 1597);
    }
}
