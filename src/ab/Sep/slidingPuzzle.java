package ab.Sep;

import java.util.*;

public class slidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>();
        String target = "123450";
        // convert board to string - initial state.
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        Queue<String> q = new LinkedList<>(Arrays.asList(s));
        seen.add(s);
        int ans = 0;
        while (!q.isEmpty()) {
            // loop used to control search breadth.
            for (int sz = q.size(); sz > 0; --sz) {
                String str = q.poll();
                if (str.equals(target)) {
                    return ans;
                }
                // locate '0'
                int i = str.indexOf('0');
                // potential swap displacements.
                int[] d = { 1, -1, 3, -3 };
                // traverse all options.
                for (int k = 0; k < 4; ++k) {
                    int j = i + d[k];
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j ==2) {
                        continue;
                    }
                    char[] ch = str.toCharArray();
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    s = String.valueOf(ch);
                    if (seen.add(s)) {
                        q.offer(s);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
