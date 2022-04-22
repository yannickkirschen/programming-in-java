package sh.yannick.dhbw.cli.model.args;

import lombok.Data;

import java.util.List;

@Data
public class StudentCreateArguments {
    private String id;
    private String name;
    private List<String> lectureIds;
}
