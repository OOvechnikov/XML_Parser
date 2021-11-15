package comparator;

public class ExactComparator extends Comparator {

    public ExactComparator(String template) {
        super(template);
    }


    @Override
    public boolean compare(String fileName) {
        return fileName.equals(super.getTemplate());
    }
}
