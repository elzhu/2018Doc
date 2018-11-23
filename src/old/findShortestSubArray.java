package old;

import java.util.HashMap;

public class findShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
               int[] current = map.get(nums[i]);
               current[0]++;
               current[2] = i;
            }else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int degree  = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree) {
                res = Math.min(value[2] - value[1] + 1, res);
            }
        }
        return res;
    }

    public static void main(String [ ] args)
    {
        int[] nums = {1,2,2,3,1,4,2};

        System.out.println("leetcode.Aug.findShortestSubArray: " + findShortestSubArray(nums));
    }
}

