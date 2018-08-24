package graph;

import java.util.*;

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

    public Map<CharSequence, Node> getGraph() {
        return graph;
    }

    public Deque<Node> findPath(CharSequence startWord, CharSequence endWord) {
        Queue<Node> toVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();

        toVisit.add(getNode(startWord));

        while(!toVisit.isEmpty()) {
            Node currentNode = toVisit.poll();

            if (currentNode.hasWord(endWord)) {
                return new LinkedList<>();
            }
            visited.add(currentNode);
            
        }
        return new LinkedList<>();
    }
}
