package old;

import java.util.HashMap;

public class findLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }

    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        if(nums.length == 1){
            return 0;
        }
        int max = Integer.MIN_VALUE + 1;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                index = i;
            } else if(nums[i] != max && nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        if(secondMax * 2 <= max){
            return index;
        }
        return -1;
    }
}
