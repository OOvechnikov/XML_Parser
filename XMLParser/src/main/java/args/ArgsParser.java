package args;

import constant.Constants;
import exeption.ArgumentException;

import java.io.File;

public class ArgsParser {

    private String fileName = "";
    private String template = "";
    private Constants.SearchType searchType;

    public ArgsParser(String[] args) {
        parseArgs(args);
    }


    private void parseArgs(String[] args) throws ArgumentException {
        if (args.length == 2) {
            fileName = args[1];
            if (!new File(args[1]).exists()) {
                throw new ArgumentException("file: " + args[1] + " doesn't exist.");
            }
            if (!args[0].equals(Constants.FILE_KEY_ARG)) {
                throw new ArgumentException("first arg must be '" + Constants.FILE_KEY_ARG + "'");
            }
            searchType = Constants.SearchType.FULL;
        } else if (args.length == 4) {
            fileName = args[1];
            if (!new File(args[1]).exists()) {
                throw new ArgumentException("file: " + args[1] + " doesn't exist.");
            }
            switch (args[2]) {
                case Constants.EXACT_AND_SIMPLE_SEARCH_KEY_ARG: {
                    template = args[3];
                    if (template.matches("\\*\\.[a-z]+")) {
                        searchType = Constants.SearchType.SIMPLE;
                    } else {
                        searchType = Constants.SearchType.EXACT;
                    }
                    break;
                }
                case Constants.EXTENDED_SEARCH_KEY_ARG: {
                    searchType = Constants.SearchType.EXTENDED;
                    template = args[3];
                    break;
                }
                default: throw new ArgumentException("Third arg must be:\n'" +
                        Constants.EXACT_AND_SIMPLE_SEARCH_KEY_ARG + "' - exact search (file-1498940214.xhtml) and simple search (*.java)\n'" +
                        Constants.EXTENDED_SEARCH_KEY_ARG + "' - extended search (regex)");
            }
        } else {
            throw new ArgumentException("Agrs qty must be 2 or 4 (-f (filename) (search type key) (search template))");
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Constants.SearchType getSearchType() {
        return searchType;
    }

    public String getTemplate() {
        return template;
    }
}
