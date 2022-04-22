package sh.yannick.dhbw.cli;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import sh.yannick.dhbw.cli.model.entity.*;

public final class HibernateConfiguration {
    private final Configuration configuration;

    public HibernateConfiguration() {
        configuration = new Configuration().configure()
            .addAnnotatedClass(Lecture.class)
            .addAnnotatedClass(Student.class);
    }

    public SessionFactory getSessionFactory() {
        return configuration.buildSessionFactory(
            new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build());
    }
}
