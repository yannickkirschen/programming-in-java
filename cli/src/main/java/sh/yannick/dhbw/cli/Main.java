package sh.yannick.dhbw.cli;

import sh.yannick.dhbw.cli.handler.*;
import sh.yannick.dhbw.cli.model.args.*;
import sh.yannick.dhbw.cli.parser.*;

public class Main {
    private static final String GLOBAL_HELP = """
        Usage:
          java -jar cli.jar [command] [options]

        Available Commands:
          create lecture [options]    Create a new lecture
          create student [options]    Create a new student
          print student [options]     Print all information on a student

        Options:
          --help  Help for this application and commands
        """;

    public static void main(String[] args) throws CommandLineParseException {
        if (args.length < 1) {
            System.out.println(GLOBAL_HELP);
            System.exit(-1);
        }

        if (args.length == 1 && "--help".equals(args[0])) {
            System.out.println(GLOBAL_HELP);
            System.exit(0);
        }

        if (args.length >= 2) {
            NestedCommandLineParser<LectureCreateArguments> lectureCreateParser = new LectureCreateCommandLineParser();
            NestedCommandLineParser<StudentCreateArguments> studentCreateParser = new StudentCreateCommandLineParser();
            NestedCommandLineParser<String> studentPrintParser = new StudentPrintCommandLineParser();

            if (lectureCreateParser.matches(args)) {
                new LectureCreateHandler().accept(lectureCreateParser.parse(args));
            } else if (studentCreateParser.matches(args)) {
                new StudentCreateHandler().accept(studentCreateParser.parse(args));
            } else if (studentPrintParser.matches(args)) {
                new StudentPrintHandler().accept(studentPrintParser.parse(args));
            }

            System.exit(0);
        }

        System.out.println(GLOBAL_HELP);
        System.exit(-1);
    }
}
