package old;

import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n >= 10) {
            int first = n/10;
            int second = n%10;
            n = first * first + second * second;
        }
        return n == 1;
    }

    public boolean isHappy2(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int sum, remain;
        while (inLoop.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }

    public boolean isHappy3(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int tmp = n;
            int sum = 0;

            while (tmp > 0) {
                int digit = tmp % 10;
                sum += digit * digit;
                tmp /= 10;
            }

            n = sum;

            if (set.contains(n))
                return false;
            else
                set.add(n);
        }

        return true;
    }
}
