import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private final StringBuilder fileNameBuilder = new StringBuilder();
    private final StringBuilder directoryNameBuilder = new StringBuilder();
    private boolean isFile = false;
    private boolean isName = false;
    private boolean isDirectory = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("node")) {
            fileNameBuilder.delete(0, fileNameBuilder.length());
            directoryNameBuilder.delete(0, directoryNameBuilder.length());
        }
        if (attributes.getLength() != 0 && attributes.getValue("is-file").equals("true"))
            isFile = true;
        if (attributes.getLength() != 0 && attributes.getValue("is-file").equals("false"))
            isDirectory = true;
        if (qName.equals("name"))
            isName = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isFile && isName) {
            fileNameBuilder.append(directoryNameBuilder).append(new String(ch, start, length)).append("\n");
            isFile = false;
            isName = false;
        }
        if (isDirectory && isName) {
            if (directoryNameBuilder.length() != 0) {
                directoryNameBuilder.append(new String(ch, start, length)).append("/");
            } else {
                directoryNameBuilder.append(new String(ch, start, length));
            }
            isDirectory = false;
            isName = false;
        }
    }

    public StringBuilder getFileNameBuilder() {
        return fileNameBuilder;
    }

}
