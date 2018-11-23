package ab.Sep;

public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int i = 0;
        // update the number's position and make it as nums[i] == i + 1; = > i = nums[i] - 1 = index
        while (i < nums.length) {
            int index = nums[i] - 1;
//            System.out.println("i : " + i);
//            System.out.println("index : " + index);
//            System.out.println("num[index] : " + nums[index]);
//            System.out.println("nums[i] " + nums[i]);
            if (nums[i] == i + 1 || nums[i] > nums.length || nums[i] <= 0) {
                i++;
            } else if (index != i) {
                swap(nums, i, index);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            System.out.println("----right order of nums of  " + i + " is :" + nums[i]);
            i++;
        }

        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1,3,-1,-5,4,9};
        System.out.println("-----firstMissingPositive: " + firstMissingPositive(nums));

    }
}
