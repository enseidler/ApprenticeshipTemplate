package calendarios.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.MonthDay;

@Entity
public class ReglaDeFeriadoDiaDeMes extends ReglaDeFeriado {

    private MonthDay diaDeMesFeriado;

    public ReglaDeFeriadoDiaDeMes() {}

    public ReglaDeFeriadoDiaDeMes(MonthDay unDiaDeMes) {
        diaDeMesFeriado = unDiaDeMes;
    }

    public MonthDay getDiaDeMesFeriado() {
        return diaDeMesFeriado;
    }

    private void setDiaDeMesFeriado(MonthDay unDiaDeMesFeriado) {
        this.diaDeMesFeriado = unDiaDeMesFeriado;
    }

    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return diaDeMesFeriado.equals(MonthDay.of(unaFecha.getMonth(), unaFecha.getDayOfMonth()));
    }
}
