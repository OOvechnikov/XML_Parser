package constant;

public class Constants {

    public static final String IS_FILE = "is-file";
    public static final String NODE = "node";
    public static final String NAME = "name";
    public static final String CHILDREN = "children";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String FILE_KEY_ARG = "-f";
    public static final String EXACT_AND_SIMPLE_SEARCH_KEY_ARG = "-s";
    public static final String EXTENDED_SEARCH_KEY_ARG = "-S";
    public static final char DOT = '.';
    public static final char SLASH = '/';

    public enum SearchType{
        FULL,
        EXACT,
        SIMPLE,
        EXTENDED
    }

    private Constants() {}
}
