package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphFactory {

    private Map<CharSequence, Set<CharSequence>> wordsProcessed;
    private Map<CharSequence, Node> nodes;
    private Set<CharSequence> wordList;

    public GraphFactory(Set<CharSequence> wordList) {
        this.wordsProcessed = new HashMap<>();
        this.nodes = new HashMap<>();
        this.wordList = wordList;
    }

    public void handleBuildGraph() {
        prepareWordsForGraph();
        buildGraph();
    }

    private void buildGraph() {
        wordsProcessed.keySet()
                .stream()
                .map(this::getNodeFor)
                .forEach(node -> addAdjacentWords(node, getWordsFor(node)));
    }

    private void addAdjacentWords(Node node, Set<CharSequence> words) {
        words.stream()
                .map(this::getNodeFor)
                .forEach(node::addAdjacent);
    }

    private Node getNodeFor(CharSequence word) {
        nodes.computeIfAbsent(word, value -> new Node(value));
        return nodes.get(word);
    }

    private void prepareWordsForGraph() {
        wordList.forEach(word -> wordsProcessed.putIfAbsent(word, findAdjacent(word)));
    }

    private Set<CharSequence> findAdjacent(CharSequence word) {
        Set<CharSequence> adjacentWords = new HashSet<>();

        wordList.stream()
                .filter(element -> isAdjacent(element, word))
                .forEach(adjacentWords::add);

        return adjacentWords;
    }

    private boolean isAdjacent(CharSequence word, CharSequence wordAdjacent) {
        int differences = 0;

        int range = word.length();
        for (int i = 0; i < range; i++) {
            if(word.charAt(i) != wordAdjacent.charAt(i)) {
                differences++;
            }
        }
        return differences == 1;
    }

    private Set<CharSequence> getWordsFor(Node node) {
        return wordsProcessed.get(node.getWord());
    }

    public Graph initializeGraph() {
        return new Graph(nodes);
    }
}
