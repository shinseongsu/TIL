package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public int[] solution(String[] words, String[] queries) {
        Trie trie = new Trie();
        Trie invTrie = new Trie();

        for (String word: words) {
            StringBuilder sb = new StringBuilder(word);
            trie.addWord(word);
            invTrie.addWord(sb.reverse().toString());
        }

        List<Integer> resultList = new ArrayList<>();
        for (String query: queries) {
            if (query.charAt(0) != '*') {
                resultList.add(trie.getResult(query));
            } else {
                StringBuilder sb = new StringBuilder(query);
                resultList.add(invTrie.getResult(sb.reverse().toString()));
            }
        }
        return resultList.stream().
            mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(
            solution2.solution(
                new String[] {"hello", "hell", "good", "goose", "children", "card", "teachable"},
                new String[] {"hell*", "goo*", "*able", "qua*"}
            )
        ));
    }

    class Node {
        char val;
        Map<Character, Node> children = new HashMap<>();
        int words = 0;

        public Node(char val) {
            this.val = val;
        }
    }

    class Trie {
        Node head = new Node('\n');

        public void addWord(String word) {
            Node curr = head;

            for (char c: word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node(c));
                }
                curr = curr.children.get(c);
                curr.words++;
            }
        }

        public int getResult(String query) {
            Node curr = head;

            for (char c: query.toCharArray()) {
                if (c == '*') {
                    return curr.words;
                }
                if (!curr.children.containsKey(c)) {
                    return 0;
                }
                curr = curr.children.get(c);
            }
            return curr.words;
        }
    }

}

