package calendarios.repositorios;

import calendarios.modelo.CalendarioDeFeriados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeCalendariosDeFeriados  extends JpaRepository<CalendarioDeFeriados, Long> {
}
