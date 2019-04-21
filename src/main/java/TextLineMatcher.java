import exceptions.IncorrectLineException;

public class TextLineMatcher {
    private String lineFromText;
    private String lineFromUser;

    public void matchLines(String lineFromText, String lineFromUser) throws IncorrectLineException {
        this.lineFromText = lineFromText;
        this.lineFromUser = lineFromUser;

        if (lineFromText.length() < lineFromUser.length()) {
            loopOverLines(lineFromText);
            throw new IncorrectLineException(String.format("Wrong char at index \'%d\'. Expected \'%s\', got \'%s\'.",
                    lineFromText.length(), "", Character.toString(lineFromUser.charAt(lineFromText.length()))));
        } else if (lineFromText.length() >  lineFromUser.length()) {
            loopOverLines(lineFromUser);
            throw new IncorrectLineException(String.format("Wrong char at index \'%d\'. Expected \'%s\', got \'%s\'.",
                    lineFromUser.length(), Character.toString(lineFromText.charAt(lineFromUser.length())),""));
        } else {
            loopOverLines(lineFromText);
        }
    }

    private void loopOverLines(String shorterLine) throws IncorrectLineException {
        for (int i = 0; i < shorterLine.length(); i++) {
            if (lineFromText.charAt(i) == lineFromUser.charAt(i))
                continue;
            else {
                throw new IncorrectLineException(String.format("Wrong char at index \'%d\'. Expected \'%s\', got \'%s\'.", i,
                        Character.toString(lineFromText.charAt(i)), Character.toString(lineFromUser.charAt(i))));
            }
        }
    }
}
