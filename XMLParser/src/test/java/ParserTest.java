import junit.framework.TestCase;
import org.xml.sax.SAXException;
import saxParser.Parser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserTest extends TestCase {

    private String[] args;
    private List<String> expected;

    public void testFullSearch() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml"};
        expected = new ArrayList<>();
        expected.add("/file-10.xml");
        expected.add("/dir-20/file-200.java");
        expected.add("/dir-20/dir-30/file-301.xhtml");
        expected.add("/dir-20/file-1018.java");
        expected.add("/dir-20/dir-31/file-311.xhtml");
        expected.add("/dir-21/file-210.java");
        expected.add("/dir-21/dir-211/file-2110.xhtml");
        expected.add("/dir-21/file-211.java");
        expected.add("/dir-21/dir-212/file-2120.xhtml");

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testExactSearchFound() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-s", "file-301.xhtml"};
        expected = new ArrayList<>();
        expected.add("/dir-20/dir-30/file-301.xhtml");

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testExactSearchNotFound() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-s", "file.xhtml"};
        expected = null;

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testSimpleSearchFound() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-s", "*.java"};
        expected = new ArrayList<>();
        expected.add("/dir-20/file-200.java");
        expected.add("/dir-20/file-1018.java");
        expected.add("/dir-21/file-210.java");
        expected.add("/dir-21/file-211.java");

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testSimpleSearchIncorrectTemplate() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-s", "words.java"};
        expected = null;

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testSimpleSearchNotFound() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-s", "*.exe"};
        expected = null;

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testExtendedSearchFound1() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-S", ".*?[a-z]{4}-\\\\d+\\.[a-z]+"};
        expected = null;

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testExtendedSearchFound2() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-S", ".*?[a-z]{4}-\\d+\\.[a-z]+"};
        expected = new ArrayList<>();
        expected.add("/file-10.xml");
        expected.add("/dir-20/file-200.java");
        expected.add("/dir-20/dir-30/file-301.xhtml");
        expected.add("/dir-20/file-1018.java");
        expected.add("/dir-20/dir-31/file-311.xhtml");
        expected.add("/dir-21/file-210.java");
        expected.add("/dir-21/dir-211/file-2110.xhtml");
        expected.add("/dir-21/file-211.java");
        expected.add("/dir-21/dir-212/file-2120.xhtml");

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testExtendedSearchFound3() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-S", ".*?[a-z]{4}-\\d{3}\\.[a-z]+"};
        expected = new ArrayList<>();
        expected.add("/dir-20/file-200.java");
        expected.add("/dir-20/dir-30/file-301.xhtml");
        expected.add("/dir-20/dir-31/file-311.xhtml");
        expected.add("/dir-21/file-210.java");
        expected.add("/dir-21/file-211.java");

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

    public void testExtendedSearchNotFound() throws ParserConfigurationException, IOException, SAXException {
        args = new String[] {"-f", "src/main/resources/example.xml", "-S", "...\\.+"};
        expected = null;

        List<String> actual = new Parser(args).getResult();
        assertEquals(expected, actual);
    }

}

