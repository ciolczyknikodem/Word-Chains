package controller;

import dao.FileWordLoader;
import tools.ClientConsole;
import view.ConsoleView;

import java.util.Set;

public class WordChain {

    private static String filePath = "src/main/resources/wordlist/wordlist.txt";
    private static int START_WORD_INDEX = 0;
    private static int END_WORD_INDEX = 1;


    public void handleSearchWordsChain() {
        String[] startingElements = prepareWordsForSearch();
        Set<CharSequence> wordList = initializeWordContainer(getWordsLength(startingElements));

        if (isWordExistInContainer(startingElements[START_WORD_INDEX], wordList) &&
                        isWordExistInContainer(startingElements[END_WORD_INDEX], wordList)) {
            // TODO: initialize graph
            // TODO: searching algorithm
        } else {
            ConsoleView.display("Word(s) aren't in container, try type another.");
        }
    }

    private String[] prepareWordsForSearch() {
        ClientConsole clientConsole = new ClientConsole();
        return clientConsole.getWordsFromUser();
    }

    private int getWordsLength(String[] words) {
        return words[START_WORD_INDEX].length();
    }

    private Set<CharSequence> initializeWordContainer(int wordLength) {
        FileWordLoader wordLoader = new FileWordLoader(filePath, wordLength);
        return wordLoader.loadWords();
    }

    private boolean isWordExistInContainer(String word, Set<CharSequence> wordList) {
        return wordList.contains(word);
    }
}
