import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {

    public static void main(String[] args) throws Exception{
        boolean haveFileName = false, haveTemplate = false;
        String fileName = "", mode = "", template = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                fileName = args[i + 1];
                haveFileName = true;
            }
            if (args[i].equals("-e") || args[i].equals("-s") || args[i].equals("-S")) {
                mode = args[i];
                template = args[i + 1];
                haveTemplate = true;
            }
        }

        if (!haveFileName) {
            System.out.println("No file name entered. Use -f parameter.");
            return;
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(fileName, handler);

        String[] array = handler.getFileNameBuilder().toString().split("\n");
        if (!haveTemplate) {
            for (String line : array) {
                System.out.println(line);
            }
        } else {
            switch (mode) {
                case "-e" : {
                    for (String line : array) {
                        String[] parts = line.split("/");
                        if (parts[parts.length - 1].equals(template)) {
                            System.out.println(line);
                        }
                    }
                }
                case "-s" : {
                    template = template.substring(2);
                    for (String line : array) {
                        String[] parts = line.split("/");
                        if (parts[parts.length - 1].substring(parts[parts.length - 1].indexOf(".") + 1).equals(template)) {
                            System.out.println(line);
                        }
                    }
                }
                case "-S" : {
                    for (String line : array) {
                        if (line.matches(template)) {
                            System.out.println(line);
                        }
                    }
                }
            }

        }

    }

}
