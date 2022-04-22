package sh.yannick.dhbw.cli.repository;

import org.hibernate.*;
import sh.yannick.dhbw.cli.model.entity.Student;

public class StudentRepository implements JpaRepository<Student, String> {
    @Override
    public Student findById(String id) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.find(Student.class, id);
            tx.commit();

            return student;
        }
    }

    @Override
    public void save(Student student) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(student);

            tx.commit();
        }
    }
}
