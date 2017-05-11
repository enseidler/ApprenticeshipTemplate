package calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HolidayCalendarMainRunner extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.profiles("local");
        return application.sources(HolidayCalendarMainRunner.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HolidayCalendarMainRunner.class, args);
    }

}
