package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {

    private Map<CharSequence, Node> nodes;
    private Graph graph;
    private CharSequence startWord;
    private CharSequence wordBetween1;
    private CharSequence wordBetween2;
    private CharSequence endWord;
    private CharSequence wordNotConnected;

    private Node startNode;
    private Node nodeBetween1;
    private Node nodeBetween2;
    private Node endNode;
    private Node nodeNotConnected;

    @BeforeEach
    void initializeGraphAndWordsForTest() {
        nodes = new HashMap<>();
        startWord = "cat";
        wordBetween1 = "cot";
        wordBetween2 = "cog";
        endWord = "dog";
        wordNotConnected = "notConnectedWord";

        startNode = new Node(startWord);
        nodeBetween1 = new Node(wordBetween1);
        nodeBetween2 = new Node(wordBetween2);
        endNode = new Node(endWord);
        nodeNotConnected = new Node(wordNotConnected);

        startNode.addAdjacent(nodeBetween1);
        nodeBetween1.addAdjacent(nodeBetween2);
        nodeBetween2.addAdjacent(endNode);

        nodes.put(startWord, startNode);
        nodes.put(wordBetween1, nodeBetween1);
        nodes.put(wordBetween2, nodeBetween2);
        nodes.put(endWord, endNode);
        nodes.put(wordNotConnected, nodeNotConnected);

        graph = new Graph(nodes);
    }

    @Test
    void addNodeTest() {
        graph.addNode(new Node(wordBetween2));

        Node result = graph.getNode("cat");
        String expected = "cat";

        assertEquals(expected, result.getWord());
    }

    @Test
    void isFirstChainInChainPathEqualsToStartingWordTest() {
        Deque<Node> chainPath = graph.searchForChainPath(startWord, endWord);

        CharSequence expected = startWord;
        CharSequence result = chainPath.getFirst().getWord();

        assertEquals(expected, result);
    }

    @Test
    void isLastElementInChainPathEqualsToEndWordTest() {
        Deque<Node> chainPath = graph.searchForChainPath(startWord, endWord);

        CharSequence expected = endWord;
        CharSequence result = chainPath.getLast().getWord();

        assertEquals(expected, result);
    }

    @Test
    void isChainPathContainsWordBetweenTest() {
        Deque<Node> chainPath = graph.searchForChainPath(startWord, endWord);

        assertTrue(chainPath.contains(nodeBetween1));
    }

    @Test
    void wrongFirstWordShouldReturnEmptyListTest() {
        Deque<Node> chainPath = graph.searchForChainPath("wrongWord", endWord);

        assertTrue(chainPath.isEmpty());
    }

    @Test
    void wrongEndWordShouldReturnEmptyListTest() {
        Deque<Node> chainPath = graph.searchForChainPath(startWord, "wrongWord");

        assertTrue(chainPath.isEmpty());
    }

    @Test
    void bothWordForSearchAreNotPresentInGraphTest() {
        Deque<Node> chainPath = graph.searchForChainPath("wrongStartWord", "wrongEndWord");

        assertTrue(chainPath.isEmpty());
    }

    @Test
    void notConnectedWordShouldReturnEmptyListTest() {
        Deque<Node> chainPath = graph.searchForChainPath(wordNotConnected, endWord);

        assertTrue(chainPath.isEmpty());
    }

}