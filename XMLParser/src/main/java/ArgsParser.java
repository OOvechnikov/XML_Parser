import java.io.File;

public class ArgsParser {

    private String fileName = "";
    private String mode = "";
    private String template = "";
    private boolean simpleParse;

    public ArgsParser(String[] args) {
        parseArgs(args);
    }

    private void parseArgs(String[] args) throws ArgumentException{
        if (args.length == 2 || args.length == 4) {
            if (!args[0].equals("-f")) {
                throw new ArgumentException("first arg must be '-f'");
            }
            fileName = args[1];
            if (!new File(args[1]).exists()) {
                throw new ArgumentException("file: " + args[1] + " doesn't exist.");
            }

            if (args.length == 4) {
                simpleParse = true;
                mode = args[2];
                if (mode.equals("-e") || mode.equals("-s") || mode.equals("-S")) {
                    template = args[3];
                } else {
                    throw new ArgumentException("third arg must be:\n'-e' - exact search (file-1498940214.xhtml)\n'-s' - simple search (*.java)\n'-S' - extended search (regex)");
                }
            }
        } else throw new ArgumentException("agrs qty must be 2 or 4");
    }

    public String getFileName() {
        return fileName;
    }

    public String getMode() {
        return mode;
    }

    public String getTemplate() {
        return template;
    }

    public boolean isSimpleParse() {
        return simpleParse;
    }

}
