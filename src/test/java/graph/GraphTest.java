package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;
    private Node node1;
    private Node node2;

    @BeforeEach
    void initializeGraph() {
        graph = new Graph();
        node1 = new Node("cat");
        node2 = new Node("cot");
    }

    @Test
    void addNodeTest() {
        graph.addNode(node1);

        Node result = graph.getNode("cat");
        String expected = "cat";

        assertEquals(expected, result.getWord());
    }

}