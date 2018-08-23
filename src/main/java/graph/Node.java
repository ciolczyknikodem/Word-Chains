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

    public boolean hasWord(CharSequence word) {
        return this.word.equals(word.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return word != null && word.equals(node.word);
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
