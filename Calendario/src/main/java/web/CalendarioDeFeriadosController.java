package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import servicios.ServicioDeCalendariosDeFeriados;

@Controller
public class CalendarioDeFeriadosController {
    private ServicioDeCalendariosDeFeriados servicio;

    @Autowired
    public CalendarioDeFeriadosController(ServicioDeCalendariosDeFeriados servicioDeMensajes) {
        this.servicio = servicioDeMensajes;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        return "hola";
    }
}
