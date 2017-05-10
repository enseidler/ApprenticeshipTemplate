package calendarios.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ReglaDeFeriadoConIntervalo extends ReglaDeFeriado {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private IntervaloDeTiempo intervalo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ReglaDeFeriado reglaDeFeriado;

    public ReglaDeFeriadoConIntervalo() {}

    public ReglaDeFeriadoConIntervalo(ReglaDeFeriado unaReglaDeFeriado, IntervaloDeTiempo unIntervalo){
        reglaDeFeriado = unaReglaDeFeriado;
        intervalo = unIntervalo;
    }

    public IntervaloDeTiempo getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(IntervaloDeTiempo unIntervaloDeTiempo) {
        this.intervalo = unIntervaloDeTiempo;
    }

    public ReglaDeFeriado getReglaDeFeriado() {
        return reglaDeFeriado;
    }

    public void setReglaDeFeriado(ReglaDeFeriado unaReglaDeFeriado) {
        this.reglaDeFeriado = unaReglaDeFeriado;
    }

    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return reglaDeFeriado.esFeriado(unaFecha) && intervalo.contains(unaFecha);
    }

}
