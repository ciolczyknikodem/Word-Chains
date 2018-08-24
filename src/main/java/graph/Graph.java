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
        Map<Node, Node> parents = new HashMap<>();
        Queue<Node> toVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        toVisit.add(getNode(startWord));

        while(!toVisit.isEmpty()) {
            Node currentNode = toVisit.poll();

            if (currentNode.hasWord(endWord)) {
                return buildPath(currentNode, parents);
            }
            visited.add(currentNode);

            currentNode.getAdjacents()
                    .stream()
                    .filter(adjacent -> !visited.contains(adjacent))
                    .forEach(adjacent -> {
                        toVisit.add(adjacent);
                        parents.putIfAbsent(adjacent, currentNode);
                    });
        }
        return new LinkedList<>();
    }

    private Deque<Node> buildPath(Node node, Map<Node, Node> parents) {
        Deque<Node> chainPath = new LinkedList<>();
        Node current = node;

        while (current != null) {
            chainPath.push(current);
            current = parents.get(current);
        }

        return chainPath;
    }
}
