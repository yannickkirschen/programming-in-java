package sh.yannick.dhbw.cli.repository;

import org.hibernate.*;
import sh.yannick.dhbw.cli.model.entity.Lecture;

public class LectureRepository implements JpaRepository<Lecture, String> {
    @Override
    public Lecture findById(String id) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Lecture lecture = session.find(Lecture.class, id);
            tx.commit();

            return lecture;
        }
    }

    @Override
    public void save(Lecture lecture) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(lecture);

            tx.commit();
        }
    }
}
