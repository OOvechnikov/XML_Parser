package args;

import constant.Constants;

public class ArgsStorage {

    private String fileName = "";
    private String template = "";
    private Constants.SearchType searchType;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Constants.SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(Constants.SearchType searchType) {
        this.searchType = searchType;
    }
}
