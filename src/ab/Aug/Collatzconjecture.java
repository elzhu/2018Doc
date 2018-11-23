package ab.Aug;

import java.util.HashMap;
import java.util.Map;

public class Collatzconjecture {
    static Map<Integer, Integer> map = new HashMap<>();
    public static int findLongestStep(int num) {
        if (num < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int t = findStep(i);
            map.put(i, t);

            res = Math.max(res, t);
            System.out.println("-------current res : " + res);
        }
        return res;
    }

    public static int findStep(int num) {
        if (num <= 1) {
            return 1;
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }
        if (num % 2 == 0) {
            return 1 + findStep(num/2);
        }
        return 1 + findStep(num * 3 + 1);
    }

    public static void main(String [] args) {
        int n = 10;
        System.out.println("-------findStep : " + findStep(n));
        System.out.println("-------findLongestStep : " + findLongestStep(n));
    }
}
