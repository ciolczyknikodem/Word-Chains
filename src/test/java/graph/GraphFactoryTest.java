package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @BeforeEach
    void initializeEnvironmentForTest() {
        word1 = "cat";
        word2 = "cot";
        word3 = "dog";
        word4 = "bug";

        wordsContainer = new HashSet<>();

        wordsContainer.add(word1);
        wordsContainer.add(word2);
        wordsContainer.add(word3);
        wordsContainer.add(word4);

        graphFactory = new GraphFactory(wordsContainer);
        graphFactory.handleBuildGraph();

    }

    @Test
    void isGraphFactoryAddNodeCorrectlyTest() {
        Map<CharSequence, Node> nodes = graphFactory.initializeGraph().getGraph();

        assertTrue(nodes.containsKey(word1));
    }

    @Test
    void lookForWordNotExistInGraphTest() {
        Map<CharSequence, Node> nodes = graphFactory.initializeGraph().getGraph();

        assertFalse(nodes.containsKey("wrongKey"));
    }
}