package sh.yannick.dhbw.cli.handler;

import sh.yannick.dhbw.cli.model.args.LectureCreateArguments;
import sh.yannick.dhbw.cli.model.entity.Lecture;
import sh.yannick.dhbw.cli.repository.*;

import java.util.function.Consumer;

public class LectureCreateHandler implements Consumer<LectureCreateArguments> {
    private final JpaRepository<Lecture, String> lectureRepository = new LectureRepository();

    @Override
    public void accept(LectureCreateArguments arguments) {
        Lecture lecture = Lecture.from(arguments);
        lectureRepository.save(lecture);
    }
}
