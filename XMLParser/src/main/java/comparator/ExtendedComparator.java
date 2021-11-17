package comparator;

import args.ArgsStorage;

public class ExtendedComparator extends Comparator {

    public ExtendedComparator(ArgsStorage argsStorage) {
        super(argsStorage);
    }


    @Override
    public boolean compare(String fileName) {
        return fileName.matches(super.getArgsStorage().getTemplate());
    }
}
