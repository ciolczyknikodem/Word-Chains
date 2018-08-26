package graph;

import java.util.*;

public class Graph {

    private final Map<CharSequence, Node> graph;

    public Graph(Map<CharSequence, Node> nodes) {
        this.graph = nodes;
    }

    public void addNode(Node node) {
        graph.put(node.getWord(), node);
    }

    public Node getNode(CharSequence word) {
        return graph.get(word);
    }

    public Deque<Node> searchForChainPath(CharSequence startWord, CharSequence endWord) {
        if (isBothNodesExistFor(startWord, endWord)) {
            return findPath(startWord, endWord);
        }
        return new LinkedList<>();
    }

    private boolean isBothNodesExistFor(CharSequence startWord, CharSequence endWord) {
        return graph.containsKey(startWord) && graph.containsKey(endWord);
    }

    private Deque<Node> findPath(CharSequence startWord, CharSequence endWord) {
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

    public Map<CharSequence, Node> getGraph() {
        return graph;
    }
}
