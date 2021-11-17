package saxParser;

import args.ArgsParser;
import comparator.ComparatorFactory;
import exeption.ArgumentException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<String> result;

    public Parser(String[] args) throws ParserConfigurationException, IOException, SAXException {
        parse(args);
    }

    private void parse(String[] args) throws ParserConfigurationException, SAXException, IOException {
        ArgsParser argsParser;
        try {
            argsParser = new ArgsParser(args);
        } catch (ArgumentException e) {
            System.out.println(e.getMessage());
            result = new ArrayList<>();
            return;
        }
        XMLHandler handler = new XMLHandler(new ComparatorFactory(argsParser.getArgsStorage()).build());
        SAXParserFactory.newInstance().newSAXParser().parse(argsParser.getArgsStorage().getFileName(), handler);
        result = handler.getResult();
    }

    public List<String> getResult() {
        if (result.size() == 0) {
            return null;
        }
        return result;
    }
}
