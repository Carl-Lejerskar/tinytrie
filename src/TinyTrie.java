import java.util.HashMap;
import java.util.HashSet;

public class TinyTrie {
     class Node {

        protected Character c;
        protected boolean eow;
        protected HashMap<Character, Node> nextChars;

        Node(Character c) {
            c = c;
            nextChars = new HashMap<>();
        }
    }
    Node root;

    public TinyTrie() {
        root = new Node(null);
    }

    public void add(String s) {

        Node curr = this.root;
        for (int i = 0, n = s.length(); i < n; i++) {

            char c = s.charAt(i);

            // if char already present in trie
            if (curr.nextChars.keySet().contains(c)) {
                curr = curr.nextChars.get(c);
            } else {
                Node node = new Node(c);
                curr.nextChars.put(c, node);
            }
        }

        curr.eow = true;
    }



}
