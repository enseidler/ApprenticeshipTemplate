package fibonacci;

/**
 * Created by ezequiel on 05/04/17.
 */
public class Fibonacci {

    public static Integer valorEnPosicion(Integer posicion) {

        if(posicion > 1) {
            return valorEnPosicion(posicion-1) + valorEnPosicion(posicion-2);
        }

        return posicion;
    }

}
