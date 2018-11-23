package old;

public class maximumProduct {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0]* nums[1]*nums[2];
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            if (n < min1) {

                min2 = min1;
                min1 = n;
            } else if (n < min2){

                min2 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1*max2*max3);
    }
}
