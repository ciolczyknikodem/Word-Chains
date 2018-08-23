package graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private final Map<CharSequence, Node> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addNode(Node node) {
        graph.put(node.getWord(), node);
    }

    public Node getNode(CharSequence word) {
        return graph.get(word);
    }
}
