package sh.yannick.dhbw.cli.parser;

public interface NestedCommandLineParser<T> {
    default boolean matches(String[] args) {
        return matches(args, 0);
    }

    boolean matches(String[] args, int from);

    T parse(String[] args) throws CommandLineParseException;
}
