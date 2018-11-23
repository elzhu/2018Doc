package leetcode.Dp;

public class MaximumNumbeNight {
    public static int maxNight(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int f1 = nums[0];
        int f2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int f = Math.max(f1 + nums[i], f2);
            f1 = f2;
            f2 = f;
        }
        return f2;
    }

    public static void main(String[] args) {

    }
}
