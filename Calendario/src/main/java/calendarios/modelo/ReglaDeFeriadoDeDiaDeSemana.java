package calendarios.modelo;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
public class ReglaDeFeriadoDeDiaDeSemana extends ReglaDeFeriado {

    private DayOfWeek diaDeSemanaFeriado;

    public ReglaDeFeriadoDeDiaDeSemana() {}

    public ReglaDeFeriadoDeDiaDeSemana(DayOfWeek unDiaDeSemana) {
        diaDeSemanaFeriado = unDiaDeSemana;
    }

    public DayOfWeek getDiaDeSemanaFeriado() {
        return diaDeSemanaFeriado;
    }

    private void setDiaDeSemanaFeriado(DayOfWeek unDiaDeSemana) {
        this.diaDeSemanaFeriado = unDiaDeSemana;
    }

    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return diaDeSemanaFeriado == unaFecha.getDayOfWeek();
    }
}
