import modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

public class PruebaHibernate {

    public Long save(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        CalendarioDeFeriados calendario = new CalendarioDeFeriados();
        calendario.agregarReglaDeFeriado(new ReglaDeFeriadoDeDiaDeSemana(DayOfWeek.MONDAY));
        calendario.agregarReglaDeFeriado(new ReglaDeFeriadoDiaDeMes(MonthDay.of(5, 9)));
        calendario.agregarReglaDeFeriado(new ReglaDeFeriadoFecha(LocalDate.of(2017, 6, 10)));
        calendario.agregarReglaDeFeriado(new ReglaDeFeriadoConIntervalo(new ReglaDeFeriadoDiaDeMes(MonthDay.of(5, 22)), IntervaloDeTiempo.fromDateToDate(LocalDate.now(), LocalDate.of(2017, 6, 1))));
        Long id = (Long) session.save(calendario);
        session.flush();
        tx.commit();
        session.close();
        return id;
    }

    public CalendarioDeFeriados retrieveById(SessionFactory sessionFactory, Long id) {
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        CalendarioDeFeriados calendario = session.get(CalendarioDeFeriados.class, id);
        tx.commit();
        session.close();
        return calendario;
    }

    public static void main( String[] args ) {
        PruebaHibernate ph = new PruebaHibernate();

        SessionFactory sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();

        Long id = (Long) ph.save(sessionFactory);
        System.out.println(ph.retrieveById(sessionFactory, id).esFeriado(LocalDate.of(2017, 5, 1)));
        System.out.println(ph.retrieveById(sessionFactory, id).esFeriado(LocalDate.of(2017, 6, 10)));
        System.out.println(ph.retrieveById(sessionFactory, id).esFeriado(LocalDate.of(2017, 5, 20)));
        System.out.println(ph.retrieveById(sessionFactory, id).esFeriado(LocalDate.of(2018 , 5, 22)));
    }
}