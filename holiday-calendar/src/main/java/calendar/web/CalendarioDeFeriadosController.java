package calendar.web;

import calendar.model.HolidayCalendar;
import calendar.persistence.PersistentHolidayCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import calendar.rest.AddRequest;
import calendar.services.PersistentHolidayCalendarService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CalendarioDeFeriadosController {

    private PersistentHolidayCalendarService servicio;

    @Autowired
    public CalendarioDeFeriadosController(PersistentHolidayCalendarService aPersistentHolidayCalendarService) {
        this.servicio = aPersistentHolidayCalendarService;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("calendarios", obtener());
        return "index";
    }

    @RequestMapping(value = Endpoints.AGREGAR_CALENDARIO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    void agregar(AddRequest calendarioDeFeriados, HttpServletResponse response) throws IOException {
        servicio.save(calendarioDeFeriados.getHolidayCalendar());
        response.sendRedirect(Endpoints.HOME);
    }

    @RequestMapping(value = Endpoints.OBTENER_CALENDARIOS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<PersistentHolidayCalendar> obtener(){
        return servicio.findAll();
    }

}
