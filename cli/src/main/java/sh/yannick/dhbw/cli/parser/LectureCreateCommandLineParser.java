package sh.yannick.dhbw.cli.parser;

import org.apache.commons.cli.*;
import sh.yannick.dhbw.cli.model.args.LectureCreateArguments;

public class LectureCreateCommandLineParser implements NestedCommandLineParser<LectureCreateArguments> {
    private static final String[] ARGS = {"create", "lecture"};

    @Override
    public boolean matches(String[] args, int from) {
        if (args.length < ARGS.length) {
            return false;
        }

        return ARGS[0].equals(args[0]) && ARGS[1].equals(args[1]);
    }

    @Override
    public LectureCreateArguments parse(String[] args) throws CommandLineParseException {
        Options options = new Options();

        Option id = Option.builder().argName("id").longOpt("id").desc("ID of the lecture").hasArg(true).build();
        Option title = Option.builder().argName("title").longOpt("title").desc("Title of the lecture").hasArg(true).build();
        Option help = Option.builder().argName("help").longOpt("help").desc("Show help").hasArg(false).required(false).build();

        options.addOption(id);
        options.addOption(title);
        options.addOption(help);

        CommandLine line;
        try {
            line = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            throw new CommandLineParseException(e);
        }

        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar cli.jar create lecture", null, options, null, true);
            System.exit(0);
        }

        LectureCreateArguments lecture = new LectureCreateArguments();
        lecture.setId(line.getOptionValue("id"));
        lecture.setTitle(line.getOptionValue("title"));

        return lecture;
    }
}
