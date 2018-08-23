package graph;

import com.sun.tools.classfile.Opcode;
import dao.FileWordLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GraphFactoryTest {

    private Graph graph;
    private GraphFactory graphFactory;

    private Node testNode1;
    private Node testNode2;
    private Node testNode3;
    private Node testNode4;

    @BeforeEach
    void initializeGraphInstance() {
        testNode1 = new Node("cat");
        testNode2 = new Node("cot");
        testNode3 = new Node("dog");
        testNode4 = new Node("bug");

        Set set = Mockito.mock(Set.class);
        String[] test = new String[] {testNode1.getWord().toString(), testNode2.getWord().toString()};
        graphFactory = new GraphFactory(set, test);

    }

    @Test
    void checkIfNodeIsAdjacentTest() {
        boolean isAdjacent = graphFactory.isAdjacent(testNode1.getWord(), testNode2.getWord());

        assertTrue(isAdjacent);
    }

    @Test
    void isAdjacentReturnFalseTest() {
        boolean isAdjacent = graphFactory.isAdjacent(testNode1.getWord(), testNode4.getWord());

        assertTrue(!isAdjacent);
    }
}