package comparator;

import args.ArgsStorage;

public class ExactComparator extends Comparator {

    public ExactComparator(ArgsStorage argsStorage) {
        this.argsStorage = argsStorage;
    }


    @Override
    public boolean compare(String fileName) {
        return fileName.equals(argsStorage.getTemplate());
    }
}
