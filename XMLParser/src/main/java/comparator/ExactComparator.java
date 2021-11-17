package comparator;

import args.ArgsStorage;

public class ExactComparator extends Comparator {

    public ExactComparator(ArgsStorage argsStorage) {
        super(argsStorage);
    }


    @Override
    public boolean compare(String fileName) {
        return fileName.equals(super.getArgsStorage().getTemplate());
    }
}
