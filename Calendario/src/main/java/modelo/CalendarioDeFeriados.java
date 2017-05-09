package modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CalendarioDeFeriados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReglaDeFeriado> reglasDeFeriado;

    public CalendarioDeFeriados() {
        reglasDeFeriado = new ArrayList<>();
    }

    public List<ReglaDeFeriado> getReglasDeFeriado() {
        return reglasDeFeriado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void setReglasDeFeriado(List<ReglaDeFeriado> algunasReglasDeFeriado) {
        this.reglasDeFeriado = algunasReglasDeFeriado;
    }

    public boolean esFeriado(LocalDate unaFecha) {
        return reglasDeFeriado.stream().anyMatch(regla -> regla.esFeriado(unaFecha));
    }

    public void agregarReglaDeFeriado(ReglaDeFeriado reglaDeFeriado) {
        reglasDeFeriado.add(reglaDeFeriado);
    }
}
