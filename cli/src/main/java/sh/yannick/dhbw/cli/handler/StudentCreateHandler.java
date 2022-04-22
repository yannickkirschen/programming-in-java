package sh.yannick.dhbw.cli.handler;

import sh.yannick.dhbw.cli.model.args.StudentCreateArguments;
import sh.yannick.dhbw.cli.model.entity.*;
import sh.yannick.dhbw.cli.repository.*;

import java.util.function.Consumer;

public class StudentCreateHandler implements Consumer<StudentCreateArguments> {
    private final JpaRepository<Student, String> studentRepository = new StudentRepository();
    private final JpaRepository<Lecture, String> lectureRepository = new LectureRepository();

    @Override
    public void accept(StudentCreateArguments arguments) {
        Student student = new Student();
        student.setId(arguments.getId());
        student.setName(arguments.getName());
        student.setLectures(arguments.getLectureIds().stream().map(lectureRepository::findById).toList());

        studentRepository.save(student);
    }
}
