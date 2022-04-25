package sh.yannick.dhbw.cli.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "STUDENT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Student {
    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "NAME")
    private String name;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LECTURE_STUDENT")
    private List<Lecture> lectures;
}
