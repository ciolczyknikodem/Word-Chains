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
}
