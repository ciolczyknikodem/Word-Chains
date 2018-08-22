package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {

    private Node node1;
    private Node node2;

    @BeforeEach
    void initializeNode() {
        node1 = new Node("testWord1");
        node2 = new Node("testWord2");
    }

    @Test
    void addAdjacentTest() {
        node1.addAdjacent(node2);
    }
}