package graph;

import java.util.Iterator;
import java.util.Map;
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

    public void handleBuildGraph() {
        Node current = initializeStartNode();
        setStartingWord(current);
        
        handleFillGraph();
    }

    private void handleFillGraph() {
        Map<CharSequence, Node> words = graph.getGraph();
    
        for (CharSequence element : wordList) {
            
            if(!words.containsKey(element)) {
                Node node = new Node(element);
                words.put(element, node);
                
                findAdjacent(node);
            }
        }
    }

    private void findAdjacent(Node current) {
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
        return differences == 1;
    }

    private void setStartingWord(Node node) {
        graph.addNode(node);
    }

    private Node initializeStartNode() {
        int START_NODE_INDEX = 0;

        Node node = new Node(startingWords[START_NODE_INDEX]);
        findAdjacent(node);

        return node;
    }

    public Graph getGraph() {
        return graph;
    }
}
