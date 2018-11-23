package old;

public class findLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int max = 0;
        int prev = nums[0];
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                tmp++;
                System.out.println("tmp: " + tmp);
            } else {
                tmp = 1;
            }
            max = Math.max(max, tmp);
            prev = nums[i];
        }
        return max;
    }

    public static void main(String [ ] args)
    {
     int[] nums = {1,3,5,7};

        System.out.println("leetcode.Aug.findLengthOfLCIS: " + findLengthOfLCIS(nums));
    }
}
