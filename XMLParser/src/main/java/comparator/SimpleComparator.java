package comparator;

import constant.Constants;

public class SimpleComparator extends Comparator {

    public SimpleComparator(String template) {
        super(template);
    }


    @Override
    public boolean compare(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(Constants.DOT));
        String templateExtension = super.getTemplate().substring(super.getTemplate().lastIndexOf(Constants.DOT));
        return fileExtension.equals(templateExtension);
    }
}
