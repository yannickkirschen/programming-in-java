package sh.yannick.dhbw.cli.handler;

import sh.yannick.dhbw.cli.model.entity.*;
import sh.yannick.dhbw.cli.repository.*;

import java.util.function.Consumer;

public class StudentPrintHandler implements Consumer<String> {
    private final JpaRepository<Student, String> studentRepository = new StudentRepository();

    @Override
    public void accept(String id) {
        Student student = studentRepository.findById(id);

        System.out.printf("Student #%s%n------------%n", id);
        System.out.printf("  Name: %s%n", student.getName());
        System.out.printf("  Lectures:%n");
        for (Lecture lecture : student.getLectures()) {
            System.out.printf("      %s: %s%n", lecture.getId(), lecture.getTitle());
        }
        System.out.println();
    }
}
