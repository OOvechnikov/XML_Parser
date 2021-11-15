package comparator;

public abstract class Comparator {

    private String template = "";


    public Comparator() {
    }

    public Comparator(String template) {
        this.template = template;
    }


    public abstract boolean compare(String fileName);

    public String getTemplate() {
        return template;
    }
}
