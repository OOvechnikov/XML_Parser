package comparator;

public class FullComparator extends AbstractComparator {

    public FullComparator(String template) {
        super(template);
    }

    @Override
    public boolean compare(String fileName) {
        return true;
    }

}
