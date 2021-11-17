package comparator;

import args.ArgsStorage;
import constant.Constants;

public class SimpleComparator extends Comparator {

    public SimpleComparator(ArgsStorage argsStorage) {
       this.argsStorage = argsStorage;
    }


    @Override
    public boolean compare(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(Constants.DOT));
        String templateExtension = argsStorage.getTemplate().substring(argsStorage.getTemplate().lastIndexOf(Constants.DOT));
        return fileExtension.equals(templateExtension);
    }
}
