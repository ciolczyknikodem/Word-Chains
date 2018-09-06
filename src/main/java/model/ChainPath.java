package model;
import graph.Node;

import java.util.Deque;
import java.util.Queue;

public class ChainPath {

    private CharSequence startWord;
    private CharSequence endWord;
    private Deque<Node> chainPath;

    public ChainPath(CharSequence startWord, CharSequence endWord) {
        this.startWord = startWord;
        this.endWord = endWord;
    }

    public ChainPath() { }

    public void setStartWord(CharSequence startWord) {
        this.startWord = startWord;
    }

    public void setEndWord(CharSequence endWord) {
        this.endWord = endWord;
    }

    public void setChainPath(Deque<Node> chainPath) {
        this.chainPath = chainPath;
    }

    public CharSequence getStartWord() {
        return startWord;
    }

    public CharSequence getEndWord() {
        return endWord;
    }

    public Queue<Node> getChainPath() {
        return chainPath;
    }
}
