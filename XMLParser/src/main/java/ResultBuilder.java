public class ResultBuilder {
    public static String getResult(String parsedString, ArgsParser argsParser) {

        String result = "";
        if (argsParser.getMode().isEmpty()) {
            return parsedString;
        } else {
            String[] array = parsedString.split("\n");
            String template = argsParser.getTemplate();
            switch (argsParser.getMode()) {
                case "-e" : {
                    for (String line : array) {
                        String[] parts = line.split("/");
                        if (parts[parts.length - 1].equals(template)) {
                            result += line + "\n";
                        }
                    }
                }
                case "-s" : {
                    template = template.substring(2);
                    for (String line : array) {
                        String[] parts = line.split("/");
                        if (parts[parts.length - 1].substring(parts[parts.length - 1].indexOf(".") + 1).equals(template)) {
                            result += line + "\n";
                        }
                    }
                }
                case "-S" : {
                    for (String line : array) {
                        if (line.matches(template)) {
                            result += line + "\n";
                        }
                    }
                }
            }
        }
        return result;
    }

}
