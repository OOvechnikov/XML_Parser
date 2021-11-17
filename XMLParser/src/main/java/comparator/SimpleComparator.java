package comparator;

import args.ArgsStorage;
import constant.Constants;

public class SimpleComparator extends Comparator {

    public SimpleComparator(ArgsStorage argsStorage) {
        super(argsStorage);
    }


    @Override
    public boolean compare(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(Constants.DOT));
        String templateExtension = super.getArgsStorage().getTemplate().substring(super.getArgsStorage().getTemplate().lastIndexOf(Constants.DOT));
        return fileExtension.equals(templateExtension);
    }
}
