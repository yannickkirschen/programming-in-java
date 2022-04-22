package sh.yannick.dhbw.cli.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.List;

@Entity(name = "STUDENT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Student {
    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(targetEntity = Lecture.class)
    @ToString.Exclude
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<Lecture> lectures;
}
