package tools;

import view.ConsoleView;

public class ClientConsole {

    public String[] getWordsFromUser() {
        String startWord;
        String endWord;

        while(true) {
            ConsoleView.display("Type \".exit\" if you want close program.\nEnter begin word: ");
            startWord = ConsoleInputGetter.getStringInput();

            ConsoleView.display("Enter end word: ");
            endWord = ConsoleInputGetter.getStringInput();

            if (isWordsLengthSame(startWord, endWord)) {
                return new String[]{startWord, endWord};
            }
        }
    }

    private boolean isWordsLengthSame(String startWord, String endWord) {
        return startWord.length() == endWord.length();
    }
}
