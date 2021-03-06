package sh.yannick.dhbw.cli.parser;

import org.apache.commons.cli.*;
import sh.yannick.dhbw.cli.model.args.StudentCreateArguments;

import java.util.Arrays;

public class StudentCreateCommandLineParser implements NestedCommandLineParser<StudentCreateArguments> {
    private static final String[] ARGS = {"create", "student"};

    @Override
    public boolean matches(String[] args, int from) {
        if (args.length < ARGS.length) {
            return false;
        }

        return ARGS[0].equals(args[0]) && ARGS[1].equals(args[1]);
    }

    @Override
    public StudentCreateArguments parse(String[] args) throws CommandLineParseException {
        Options options = new Options();

        Option id = Option.builder().argName("id").longOpt("id").desc("ID of the student").hasArg(true).build();
        Option name = Option.builder().argName("name").longOpt("name").desc("Name of the student").hasArg(true).build();
        Option lectures = Option.builder().argName("lectures").longOpt("lectures").desc("IDs of lectures the student attends").hasArgs().valueSeparator(',').build();
        Option help = Option.builder().argName("help").longOpt("help").desc("Show help").hasArg(false).required(false).build();

        options.addOption(id);
        options.addOption(name);
        options.addOption(lectures);
        options.addOption(help);

        CommandLine line;
        try {
            line = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            throw new CommandLineParseException(e);
        }

        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar cli.jar create student", null, options, null, true);
            System.exit(0);
        }

        StudentCreateArguments student = new StudentCreateArguments();
        student.setId(line.getOptionValue("id"));
        student.setName(line.getOptionValue("name"));
        student.setLectureIds(Arrays.stream(line.getOptionValues("lectures")).toList());

        return student;
    }
}
