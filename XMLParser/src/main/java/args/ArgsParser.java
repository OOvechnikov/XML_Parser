package args;

import constant.Constants;
import exeption.ArgumentException;

import java.io.File;

public class ArgsParser {

    private final ArgsStorage argsStorage;

    public ArgsParser(String[] args) {
        argsStorage = new ArgsStorage();
        parseArgs(args);
    }


    private void parseArgs(String[] args) throws ArgumentException {
        if (args.length == 2) {
            argsStorage.setFileName(args[1]);
            if (!new File(argsStorage.getFileName()).exists()) {
                throw new ArgumentException("file: " + argsStorage.getFileName() + " doesn't exist.");
            }
            if (!args[0].equals(Constants.FILE_KEY_ARG)) {
                throw new ArgumentException("first arg must be '" + Constants.FILE_KEY_ARG + "'");
            }
            argsStorage.setSearchType(Constants.SearchType.FULL);
        } else if (args.length == 4) {
            argsStorage.setFileName(args[1]);
            if (!new File(argsStorage.getFileName()).exists()) {
                throw new ArgumentException("file: " + argsStorage.getFileName() + " doesn't exist.");
            }
            switch (args[2]) {
                case Constants.EXACT_AND_SIMPLE_SEARCH_KEY_ARG: {
                    argsStorage.setTemplate(args[3]);
                    if (argsStorage.getTemplate().matches("\\*\\.[a-z]+")) {
                        argsStorage.setSearchType(Constants.SearchType.SIMPLE);
                    } else {
                        argsStorage.setSearchType(Constants.SearchType.EXACT);
                    }
                    break;
                }
                case Constants.EXTENDED_SEARCH_KEY_ARG: {
                    argsStorage.setSearchType(Constants.SearchType.EXTENDED);
                    argsStorage.setTemplate(args[3]);
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

    public ArgsStorage getArgsStorage() {
        return argsStorage;
    }
}
