package graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GraphFactoryTest {
    private Set<CharSequence> wordsContainer;
    private GraphFactory graphFactory;
    
    private CharSequence word1;
    private CharSequence word2;
    private CharSequence word3;
    private CharSequence word4;
    
    private Node testNode1;
    private Node testNode2;
    private Node testNode3;
    private Node testNode4;


    @BeforeEach
    void initializeEnvironmentForTest() {
        word1 = "cat";
        word2 = "cot";
        word3 = "dog";
        word4 = "bug";

        testNode1 = new Node(word1);
        testNode2 = new Node(word2);
        testNode3 = new Node(word3);
        testNode4 = new Node(word4);

        wordsContainer = new HashSet<>();

        wordsContainer.add(word1);
        wordsContainer.add(word2);
        wordsContainer.add(word3);
        wordsContainer.add(word4);

        graphFactory = new GraphFactory(wordsContainer);
        graphFactory.handleBuildGraph();

    }

    @Test
    void checkIfNodeIsAdjacentTest() {
        boolean isAdjacent = graphFactory.isAdjacent(testNode1.getWord(), testNode2.getWord());

        assertTrue(isAdjacent);
    }

    @Test
    void isAdjacentReturnFalseTest() {
        boolean isAdjacent = graphFactory.isAdjacent(testNode1.getWord(), testNode4.getWord());

        assertFalse(isAdjacent);
    }

    @Test
    void isGraphFactoryAddNodeCorrectlyTest() {
        Map<CharSequence, Node> nodes = graphFactory.getGraph().getGraph();

        assertTrue(nodes.containsKey(word1));
    }

    @Test
    void lookForWordNotExistInGraphTest() {
        Map<CharSequence, Node> nodes = graphFactory.getGraph().getGraph();

        assertFalse(nodes.containsKey("wrongKey"));
    }
}