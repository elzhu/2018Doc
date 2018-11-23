package old;

public class findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, begin = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[n - 1 - i] > min) {
                begin = n - 1 - i;
            }
        }
        return end - begin - 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int end = 0, max = nums[0], start = nums.length, min = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                end = i;
            }
        }
        for (int j = nums.length - 2; j > 0; j--) {
            if (nums[j] < min) {
                min = nums[j];
            } else {
                start = j;
            }
        }
        return end - start - 1;
    }


}
