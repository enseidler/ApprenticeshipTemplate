package calendarios.servicios;


import calendarios.modelo.CalendarioDeFeriados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import calendarios.repositorios.RepositorioDeCalendariosDeFeriados;

import java.util.List;

@Service
public class ServicioDeCalendariosDeFeriados {

    @Autowired
    private RepositorioDeCalendariosDeFeriados repositorio;

    @Transactional
    public void guardar(CalendarioDeFeriados calendarioDeFeriados) {
        repositorio.save(calendarioDeFeriados);
    }

    public List<CalendarioDeFeriados> buscarTodos() {
        return repositorio.findAll();
    }

}
