package graph;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private final CharSequence word;
    private final Set<Node> adjacents;

    public Node(CharSequence word) {
        this.word = word;
        this.adjacents = new HashSet<>();
    }

    public void addAdjacent(Node node) {
        adjacents.add(node);
    }

    public CharSequence getWord() {
        return word;
    }

    public Set<Node> getAdjacents() {
        return adjacents;
    }
}
