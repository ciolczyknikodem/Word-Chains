package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

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


    @Test
    void getAdjacentsTest() {
        node1.addAdjacent(node2);
        Set<Node> adjacents = node1.getAdjacents();

        assertTrue(adjacents.contains(node2));
    }
}