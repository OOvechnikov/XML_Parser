import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ArgsParser argsParser = new ArgsParser(args);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLHandler handler = new XMLHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(argsParser.getFileName(), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(ResultBuilder.getResult(handler.getFileNameBuilder().toString(), argsParser));
    }

}
