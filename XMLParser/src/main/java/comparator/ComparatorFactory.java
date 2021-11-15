package comparator;

import args.ArgsParser;

public class ComparatorFactory {

    private final ArgsParser argsParser;

    public ComparatorFactory(ArgsParser argsParser) {
        this.argsParser = argsParser;
    }


    public Comparator build() {
        switch (argsParser.getSearchType()) {
            case FULL: return new FullComparator();
            case EXACT: return new ExactComparator(argsParser.getTemplate());
            case SIMPLE: return new SimpleComparator(argsParser.getTemplate());
            case EXTENDED: return new ExtendedComparator(argsParser.getTemplate());
            default: return null;
        }
    }
}
