package calendarios.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public abstract class ReglaDeFeriado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected ReglaDeFeriado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    abstract boolean esFeriado(LocalDate unaFecha);
}
