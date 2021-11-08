package comparator;

public class SimpleComparator extends AbstractComparator {

    public SimpleComparator(String template) {
        super(template);
    }

    @Override
    public boolean compare(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.')).equals(super.getTemplate().substring(super.getTemplate().lastIndexOf('.')));
    }

}
