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
        Node current = initializeStartNode();
        setStartingWord(current);

    }

    private void findAdjacents(Node current) {
        for (CharSequence element : wordList) {

            if (isAdjacent(current.getWord(), element)) {
                current.addAdjacent(new Node(element));
            }
        }
    }

    public boolean isAdjacent(CharSequence word, CharSequence wordAdjacent) {
        int differences = 0;

        int range = word.length();
        for (int i = 0; i < range; i++) {
            if(word.charAt(i) != wordAdjacent.charAt(i)) {
                differences++;
            }
        }
        return differences <= 1;
    }

    public void setStartingWord(Node node) {
        graph.addNode(node);
    }

    private Node initializeStartNode() {
        int START_NODE_INDEX = 0;

        Node node = new Node(startingWords[START_NODE_INDEX]);
        findAdjacents(node);

        return node;
    }

    public Graph getGraph() {
        return graph;
    }
}
