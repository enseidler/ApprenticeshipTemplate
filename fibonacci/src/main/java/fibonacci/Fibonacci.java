package fibonacci;

import fibonacci.errors.PosicionNegativaException;

/**
 * Created by ezequiel on 05/04/17.
 */
public class Fibonacci {

    public static Integer valorEnPosicion(Integer posicion) throws Exception {
        verificarPosicion(posicion);

        if(posicion > 1)
            return valorEnPosicion(posicion-1) + valorEnPosicion(posicion-2);

        return posicion;
    }

    private static void verificarPosicion(Integer posicion) throws PosicionNegativaException {
        if (posicion < 0)
            throw new PosicionNegativaException();
    }

}
