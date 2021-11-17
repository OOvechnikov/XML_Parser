package comparator;

import args.ArgsStorage;

public class ComparatorFactory {

    private final ArgsStorage argsStorage;

    public ComparatorFactory(ArgsStorage argsStorage) {
        this.argsStorage = argsStorage;
    }


    public Comparator build() {
        switch (argsStorage.getSearchType()) {
            case FULL: return new FullComparator();
            case EXACT: return new ExactComparator(argsStorage);
            case SIMPLE: return new SimpleComparator(argsStorage);
            case EXTENDED: return new ExtendedComparator(argsStorage);
            default: return null;
        }
    }
}
