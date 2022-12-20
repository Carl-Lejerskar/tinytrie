import java.util.HashSet;

public class TinyTrie {
    Node root;

    public TinyTrie() {
        root = new Node(null);
    }

    class Node {

        protected char c;
        protected boolean eow;
        protected HashSet<Character> nextChars;

        Node(Character c) {
            c = c;
            nextChars = new HashSet<>();
        }
    }
}