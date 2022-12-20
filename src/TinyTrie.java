import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TinyTrie {
    class Node {

        protected Character c;
        protected boolean eow;
        protected HashMap<Character, Node> nextChars;

        Node(Character c) {
            this.c = c;
            nextChars = new HashMap<>();
        }
    }

    Node root;

    public TinyTrie() {
        root = new Node(null);
    }

    public void add(String s) {
        /**
         * Adds a word to the trie
         */
        Node curr = this.root;
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            if (curr.nextChars.containsKey(c)) {
                curr = curr.nextChars.get(c);
            } else {
                Node node = new Node(c);
                curr.nextChars.put(c, node);
                curr = node;
            }
        }
        curr.eow = true;
    }

    public void remove(String s) {
        /**
         * Removes a word from the trie
         */

        Node prev = null;
        Node curr = this.root;

        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            if (prev != null && curr.nextChars.keySet().size() <= 1) {
                prev.nextChars.remove(c);
            }
            if (curr.nextChars.containsKey(c)) {
                prev = curr;
                curr = curr.nextChars.get(c);
            } else {
                return;
            }
        }

        curr.eow = false;
    }
}
