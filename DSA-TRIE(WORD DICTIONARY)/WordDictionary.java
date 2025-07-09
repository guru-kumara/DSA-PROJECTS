import java.util.Scanner;

public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return searchWord(root, word, 0);
    }

    private boolean searchWord(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(index);
        if (ch == '.') {  
            for (char c = 'a'; c <= 'z'; c++) {
                if (node.containsKey(c)) {
                    if (searchWord(node.get(c), word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (!node.containsKey(ch)) {
                return false;
            }
            return searchWord(node.get(ch), word, index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordDictionary dict = new WordDictionary();
        System.out.println("=== Word Dictionary (Trie) ===");

        while (true) {
            System.out.println("\n1. Add Word");
            System.out.println("2. Search Word");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter word to add: ");
                String word = sc.nextLine();
                dict.addWord(word);
                System.out.println("✅ Word added.");
            } else if (choice == 2) {
                System.out.print("Enter word to search (use '.' as wildcard): ");
                String word = sc.nextLine();
                boolean found = dict.search(word);
                System.out.println(found ? "✅ Word found." : "❌ Word not found.");
            } else {
                System.out.println("Exiting...");
                break;
            }
        }

        sc.close();
    }

    public class Node {
        Node[] links;
        boolean flag;

        public Node() {
            links = new Node[26];
            flag = false;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }
}
