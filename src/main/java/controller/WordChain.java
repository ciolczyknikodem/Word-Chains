package controller;

import dao.FileWordLoader;
import dao.WordLoader;
import graph.Graph;
import graph.GraphFactory;
import graph.Node;
import model.ChainPath;
import tools.ClientConsole;
import view.ConsoleView;

import java.util.Deque;
import java.util.Set;

public class WordChain {

    private static String filePath = "src/main/resources/wordlist/wordlist.txt";
    private final int START_WORD_INDEX = 0;
    private final int END_WORD_INDEX = 1;


    public void handleSearchWordsChain() {
        String[] startingElements = prepareWordsForSearch();
        Set<CharSequence> wordList = initializeWordContainer(getWordsLength(startingElements));

        if (isWordExistInContainer(startingElements[START_WORD_INDEX], wordList) &&
                        isWordExistInContainer(startingElements[END_WORD_INDEX], wordList)) {

            Graph graph = initializeGraphFactory(wordList);

            Deque<Node> chainPath = graph.searchForChainPath(
                    startingElements[START_WORD_INDEX],
                    startingElements[END_WORD_INDEX]
            );

            chainPath.forEach(node -> ConsoleView.display(node.getWord().toString()));

        } else {
            ConsoleView.display("Word(s) aren't in container, try type another.");
        }
    }

    public ChainPath handleSearchWordChain(ChainPath chainPath) {
        Set<CharSequence> wordList = initializeWordContainer(getWordsLength(new String[] {
                (String) chainPath.getStartWord(),
                (String) chainPath.getEndWord()
        }));
        Deque<Node> result = null;

        if (isWordExistInContainer((String) chainPath.getStartWord(), wordList) &&
                isWordExistInContainer((String) chainPath.getEndWord(), wordList)) {

            Graph graph = initializeGraphFactory(wordList);

            result = graph.searchForChainPath(
                    chainPath.getStartWord(),
                    chainPath.getEndWord()
            );

            result.forEach(node -> ConsoleView.display(node.getWord().toString()));

        } else {
            ConsoleView.display("Word(s) aren't in container, try type another.");
        }
        chainPath.setChainPath(result);
        return chainPath;
    }

    private String[] prepareWordsForSearch() {
        ClientConsole clientConsole = new ClientConsole();
        return clientConsole.getWordsFromUser();
    }

    private int getWordsLength(String[] words) {
        return words[START_WORD_INDEX].length();
    }

    private Set<CharSequence> initializeWordContainer(int wordLength) {
        WordLoader wordLoader = new FileWordLoader(filePath, wordLength);
        return wordLoader.loadWords();
    }

    private boolean isWordExistInContainer(String word, Set<CharSequence> wordList) {
        return wordList.contains(word);
    }

    private Graph initializeGraphFactory(Set<CharSequence> wordList) {
        GraphFactory factory = new GraphFactory(wordList);
        factory.handleBuildGraph();

        return factory.initializeGraph();
    }
}
