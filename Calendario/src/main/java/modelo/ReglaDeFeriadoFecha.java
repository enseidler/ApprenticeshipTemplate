package modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ReglaDeFeriadoFecha extends ReglaDeFeriado {

    private LocalDate fecha;

    public ReglaDeFeriadoFecha() {}

    public ReglaDeFeriadoFecha(LocalDate unaFecha){
        fecha = unaFecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    private void setFecha(LocalDate unaFecha) {
        this.fecha = unaFecha;
    }

    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return unaFecha.equals(fecha);
    }
}
