package bigf.BinarySearch;

import java.util.Random;

public class RandomPickWeight {
    Random random;
    int[] wSums;

    public RandomPickWeight(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.wSums = w;
    }
    public int pickIndex() {
        int len = wSums.length;
        int index = random.nextInt(wSums[len - 1]) + 1;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int middle = left + (right - left)/2;
            if (wSums[middle] == index) {
                return middle;
            } else if (wSums[middle] > index) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
