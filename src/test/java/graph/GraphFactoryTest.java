package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphFactoryTest {

    private Graph graph;
    private GraphFactory graphFactory;

    private Node testNode1;
    private Node testNode2;
    private Node testNode3;
    private Node testNode4;
    private Node testNode5;

    @BeforeEach
    void initializeGraphInstance() {
        graph = new Graph();
        graphFactory = new GraphFactory();

        testNode1 = new Node("cat");
        testNode2 = new Node("cot");
        testNode3 = new Node("car");
        testNode4 = new Node("cog");
        testNode5 = new Node("dog");
    }

    @Test
    void checkIfNodeIsAdjacentTest() {
        boolean isAdjacent = graphFactory.isAdjacent(testNode1, testNode2);

        assertTrue(isAdjacent);
    }

    @Test
    void isAdjacentReturnFalseTest() {
        boolean isAdjacent = graphFactory.isAdjacent(testNode1, testNode5);

        assertTrue(!isAdjacent);
    }

}