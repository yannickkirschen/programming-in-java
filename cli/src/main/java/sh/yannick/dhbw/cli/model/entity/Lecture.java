package sh.yannick.dhbw.cli.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import sh.yannick.dhbw.cli.model.args.LectureCreateArguments;

import java.util.Objects;

@Entity(name = "LECTURE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Lecture {
    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "TITLE")
    private String title;

    public static Lecture from(LectureCreateArguments arguments) {
        Lecture lecture = new Lecture();
        lecture.setId(arguments.getId());
        lecture.setTitle(arguments.getTitle());

        return lecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lecture lecture = (Lecture) o;
        return id != null && Objects.equals(id, lecture.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
