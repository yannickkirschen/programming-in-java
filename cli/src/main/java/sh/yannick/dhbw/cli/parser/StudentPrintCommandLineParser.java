package sh.yannick.dhbw.cli.parser;

import org.apache.commons.cli.*;

public class StudentPrintCommandLineParser implements NestedCommandLineParser<String> {
    private static final String[] ARGS = {"print", "student"};

    @Override
    public boolean matches(String[] args, int from) {
        if (args.length < ARGS.length) {
            return false;
        }

        return ARGS[0].equals(args[0]) && ARGS[1].equals(args[1]);
    }

    @Override
    public String parse(String[] args) throws CommandLineParseException {
        Options options = new Options();

        Option id = Option.builder().argName("id").longOpt("id").desc("ID of the student").hasArg(true).build();
        options.addOption(id);

        CommandLine line;
        try {
            line = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            throw new CommandLineParseException(e);
        }

        return line.getOptionValue("id");
    }
}
