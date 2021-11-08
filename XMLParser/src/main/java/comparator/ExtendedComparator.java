package comparator;

public class ExtendedComparator extends AbstractComparator {

    public ExtendedComparator(String template) {
        super(template);
    }

    @Override
    public boolean compare(String fileName) {
        return fileName.matches(super.getTemplate());
    }

}
