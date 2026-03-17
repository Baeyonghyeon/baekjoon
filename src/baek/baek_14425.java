package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baek_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        int result = 0;

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if (trie.search(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static class TrieNode {
        HashMap<Character, TrieNode> child;
        boolean isEndOfWord; // 단어가 끝나는지 확인 할 수 있는 장치

        public TrieNode() {
            this.child = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.child.computeIfAbsent(c, k -> new TrieNode());
            }

            node.isEndOfWord = true;
        }

        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.child.containsKey(c)) {
                    return false;
                }
                node = node.child.get(c);
            }

            return node.isEndOfWord;
        }

    }
}
