import org.xml.sax.SAXException;
import saxParser.Parser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> result = new Parser(args).getResult();
            if (result == null) {
                System.out.println("Nothing found");
                return;
            }
            for (String line : result) {
                System.out.println(line);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
