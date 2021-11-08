package comparator;

import args.ArgsParser;

public class ComparatorFactory {

    private ArgsParser argsParser;

    public ComparatorFactory(ArgsParser argsParser) {
        this.argsParser = argsParser;
    }

    public AbstractComparator build() {
        switch (argsParser.getMode()) {
            case "": return new FullComparator(argsParser.getTemplate());
            case "-e": return new ExactComparator(argsParser.getTemplate());
            case "-s": return new SimpleComparator(argsParser.getTemplate());
            case "-S": return new ExtendedComparator(argsParser.getTemplate());
            default: return null;
        }
    }

}
