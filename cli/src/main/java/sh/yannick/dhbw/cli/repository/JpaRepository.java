package sh.yannick.dhbw.cli.repository;

import org.hibernate.SessionFactory;
import sh.yannick.dhbw.cli.HibernateConfiguration;

public interface JpaRepository<T, I> {
    SessionFactory factory = new HibernateConfiguration().getSessionFactory();

    T findById(I id);

    void save(T lecture);
}
