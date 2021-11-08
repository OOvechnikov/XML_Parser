package saxParser;

import comparator.AbstractComparator;
import constant.Constants;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {

    private final AbstractComparator comparator;
    private final List<String> result = new ArrayList<>();
    private List<String> directoryList = new ArrayList<>();
    private boolean isFile = false;
    private boolean isName = false;
    private boolean isDirectory = false;

    public XMLHandler(AbstractComparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(Constants.NODE)) {
            directoryList = new ArrayList<>();
        }
        if (attributes.getLength() != 0 && attributes.getValue(Constants.IS_FILE).equals(Constants.TRUE))
            isFile = true;
        if (attributes.getLength() != 0 && attributes.getValue(Constants.IS_FILE).equals(Constants.FALSE))
            isDirectory = true;
        if (qName.equals(Constants.NAME))
            isName = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isFile && isName) {
            String fileName = new String(ch, start, length);
            String directoryName = "";
            if (comparator.compare(fileName)) {
                for (int i = 0; i < directoryList.size(); i++) {
                    if (i == 0) {
                        directoryName = directoryList.get(0);
                    } else {
                        directoryName += directoryList.get(i) + "/";
                    }
                }
                result.add(directoryName + fileName);
            }
            isFile = false;
            isName = false;
        }
        if (isDirectory && isName) {
            directoryList.add(new String(ch, start, length));
            isDirectory = false;
            isName = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(Constants.CHILDREN)) {
            directoryList.remove(directoryList.size() - 1);
        }
    }

    public List<String> getResult() {
        return result;
    }

}
