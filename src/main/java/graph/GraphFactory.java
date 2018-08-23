package graph;

import java.util.Set;

public class GraphFactory {

    private Set<CharSequence> wordList;
    private String[] startingWords;
    private Graph graph;

    public GraphFactory(Set<CharSequence> wordList, String[] startingWords) {
        this.wordList = wordList;
        this.startingWords = startingWords;
        this.graph = new Graph();
    }

    public GraphFactory() {}

    public void handleBuildGraph() {
        setStartingWord(initializeStartNode());
    }

    public void setStartingWord(Node node) {
        graph.addNode(node);
    }

    public boolean isAdjacent(Node node, Node adjacent) {
        int differences = 0;

        CharSequence word = node.getWord();
        CharSequence wordAdjacent = adjacent.getWord();

        int range = word.length();
        for (int i = 0; i < range; i++) {
            if(word.charAt(i) != wordAdjacent.charAt(i)) {
                differences++;
            }
        }
        return differences <= 1;
    }

    private Node initializeStartNode() {
        int START_NODE_INDEX = 0;
        return new Node(startingWords[START_NODE_INDEX]);
    }
}
