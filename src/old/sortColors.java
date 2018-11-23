package old;

public class sortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // start always point to 0
        // end always point to 2
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            // current value is 0
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }
            index++;
        }
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int index = start + 2;
        while (index < nums.length) {
            System.out.println("index: " + index);
            if (nums[index] > nums[start]) {
                if (nums[start + 1] > nums[start] && nums[start + 1] < nums[index]) {
                    return true;
                }
            }
            start = start + 3;
            index = start + 2;
        }
        return false;
    }

    public static void main(String [ ] args)
    {
        int[] nums = {2,1,5,0,4,6};

        System.out.println("increasingTriplet: " + increasingTriplet(nums));
    }
}
