package leetcode.Recursive;

import java.util.HashMap;

public class CollatzConjecture {

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static int findSteps(int num) {
        if (num <= 1) {
            return 1;
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }
        if (num % 2== 0) {
            return  1 + findSteps(num /2);
        }
        return 1 + findSteps(3 * num + 1);
    }

    public static int longestStep(int num) {
        if (num < 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i <= num; i++) {
            int step = findSteps(i);
            map.put(i, step);
            res = Math.max(res, step);
        }
        return res;
    }
}
