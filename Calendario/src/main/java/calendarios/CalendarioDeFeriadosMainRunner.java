package calendarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CalendarioDeFeriadosMainRunner extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.profiles("local");
        return application.sources(CalendarioDeFeriadosMainRunner.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CalendarioDeFeriadosMainRunner.class, args);
    }

}
