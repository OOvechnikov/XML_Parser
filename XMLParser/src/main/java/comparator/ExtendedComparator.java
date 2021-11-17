package comparator;

import args.ArgsStorage;

public class ExtendedComparator extends Comparator {

    public ExtendedComparator(ArgsStorage argsStorage) {
        this.argsStorage = argsStorage;
    }


    @Override
    public boolean compare(String fileName) {
        return fileName.matches(argsStorage.getTemplate());
    }
}
