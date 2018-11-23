package leetcode.Sort;

public class sortColor {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (nums[left] == 0) {
            left++;

        }

        index = left - 1;

        while (nums[right] == 2) {
            right--;
        }

        while (left < right) {
            if (nums[left] < 1) {
                index++;
                swap(nums, index, left);
                left++;
            } else if (nums[left] == 1) {
                left++;
            } else {
                swap(nums, left, right);
                right--;
            }

        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
