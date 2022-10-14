package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        Trie trie = new Trie();
        for (int i = 0; i < titles.length; i++) {
            trie.addLyric(titles[i], lyrics[i]);
        }

        List<String[]> resultList = new ArrayList<>();
        for (String query : problems) {
            resultList.add(trie.getResult(query));
        }
        return resultList.toArray(new String[0][0]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[][] arrays = solution1.solution(
            new String[]{"아모르파티", "아기상어", "올챙이와개구리", "산다는건"},
            new String[]{"산다는게다그런거지누구나빈손으로와...(후락)",
                "아기상어뚜루뚜루귀여운뚜루뚜루...(후락)",
                "개울가에올챙이한마리꼬물꼬물헤어침다...(후락)",
                "산다는건다그런거래요힘들고아픈날도많지만...(후락)"},
            new String[]{
                "산다",
                "아기상어",
                "올챙이"
            }
        );

        Arrays.stream(arrays)
            .forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    class Node {

        char val;
        Map<Character, Node> children = new HashMap<>();
        List<String> songs = new ArrayList<>();

        public Node(char val) {
            this.val = val;
        }
    }

    class Trie {

        Node head = new Node('\n');

        public void addLyric(String songName, String lyric) {
            Node curr = head;

            for (char c : lyric.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node(c));
                }
                curr = curr.children.get(c);
                curr.songs.add(songName);
            }
        }

        public String[] getResult(String query) {
            Node curr = head;

            for (char c : query.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return new String[]{};
                }
                curr = curr.children.get(c);
            }
            return curr.songs.toArray(new String[0]);
        }
    }

}

