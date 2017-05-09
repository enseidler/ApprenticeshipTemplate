package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class IntervaloDeTiempo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate inicioIntervalo;

    private LocalDate finIntervalo;

    public IntervaloDeTiempo() {}

    public IntervaloDeTiempo(LocalDate inicio, LocalDate fin){
        if(inicio.isAfter(fin)){
            throw new RuntimeException("Intervalo no valiso, la fecha de inicio debe de ser menor a la de fin");
        }
        inicioIntervalo = inicio;
        finIntervalo = fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicioIntervalo() {
        return inicioIntervalo;
    }

    public void setInicioIntervalo(LocalDate unInicioDeIntervalo) {
        this.inicioIntervalo = unInicioDeIntervalo;
    }

    public LocalDate getFinIntervalo() {
        return finIntervalo;
    }

    public void setFinIntervalo(LocalDate unFinDeIntervalo) {
        this.finIntervalo = unFinDeIntervalo;
    }

    public static IntervaloDeTiempo fromDateToDate(LocalDate inicio,LocalDate fin){
        return new IntervaloDeTiempo(inicio,fin);
    }

    public boolean contains(LocalDate fechaMedio) {
        return fechaMedio.isAfter(inicioIntervalo) && fechaMedio.isBefore(finIntervalo) || fechaMedio.equals(inicioIntervalo) || fechaMedio.equals(finIntervalo);
    }
}
