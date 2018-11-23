package ab.Sep;

import java.util.HashMap;

public class Collatzconjecture {

    static HashMap<Integer, Integer> map = new HashMap<>();

    private static int findStep(int num) {
        if (num <= 1) {
            return 1;
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }
        if (num % 2 == 0) {
            return 1 + findStep(num / 2);
        }
        return 1 + findStep(num * 3 + 1);
    }

    public static int findLogestStep(int num) {
        if (num <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i <= num; i++) {
            int t = findStep(i);
            map.put(i, t);
            res = Math.max(t, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println("--------------result: " + findLogestStep(num));
    }
}
