package bigf.DFS;

public class canPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(k <= 0 || sum%k != 0) return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, k, 0, 0, 0, sum % k);

    }

    private boolean canPartition(int[] nums, int[] visited, int k, int start, int curSum, int curNum, int target) {
        if( k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return canPartition(nums, visited, k - 1, 0, 0, 0, target);
        }
       for (int i = start; i < nums.length; i++) {
          if (visited[i] == 0) {
              visited[i] = 1;
              if (canPartition(nums, visited, k, i + 1, curSum + nums[i], curNum++, target)) {
                  return true;
              }
              visited[i] = 0;
          }
       }
        return false;
    }
}
