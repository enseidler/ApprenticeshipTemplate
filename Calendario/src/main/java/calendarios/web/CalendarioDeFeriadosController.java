package calendarios.web;

import calendarios.modelo.CalendarioDeFeriados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import calendarios.rest.AgregarRequest;
import calendarios.servicios.ServicioDeCalendariosDeFeriados;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CalendarioDeFeriadosController {

    private ServicioDeCalendariosDeFeriados servicio;

    @Autowired
    public CalendarioDeFeriadosController(ServicioDeCalendariosDeFeriados servicioDeCalendariosDeFeriados) {
        this.servicio = servicioDeCalendariosDeFeriados;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("calendarios", obtener());
        return "index";
    }

    @RequestMapping(value = Endpoints.AGREGAR_CALENDARIO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    void agregar(AgregarRequest calendarioDeFeriados, HttpServletResponse response) throws IOException {
        servicio.guardar(calendarioDeFeriados.getCalendarioDeFeriados());
        response.sendRedirect(Endpoints.HOME);
    }

    @RequestMapping(value = Endpoints.OBTENER_CALENDARIOS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<CalendarioDeFeriados> obtener(){
        return servicio.buscarTodos();
    }

}
