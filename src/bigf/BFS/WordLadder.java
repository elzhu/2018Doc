package bigf.BFS;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        ((LinkedList<String>) queue).add(beginWord);

        Set<String> set = new HashSet<String>(wordList);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(cur);
                        newWord.setCharAt(i, letter);
                        if (set.contains(newWord.toString())) {
                            if (newWord.toString().equals(endWord)) {
                                return step + 1;
                            }
                            set.remove(newWord.toString());
                            ((LinkedList<String>) queue).add(newWord.toString());
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
