package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class backtracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, res, new ArrayList<>(), 0);
        return res;
    }
    public void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> current, int start) {
        res.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            subsetsHelper(nums, res, current, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void subsetsWithDupHelper(int[] nums, List<List<Integer>> res, List<Integer> current, int start) {
        res.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            subsetsWithDupHelper(nums, res, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
