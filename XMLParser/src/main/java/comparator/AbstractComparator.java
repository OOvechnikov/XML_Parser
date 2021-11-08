package comparator;

public abstract class AbstractComparator {
    private final String template;

    public AbstractComparator(String template) {
        this.template = template;
    }

    public abstract boolean compare(String fileName);

    public String getTemplate() {
        return template;
    }

}
