package old;

public class maxSubarraySumCircular {
    public static int max = Integer.MIN_VALUE;

    public static int maxSubarraySumCircular(int[] A) {


            int index = 0;
            while (index < A.length - 1) {
                int sum = 0;

                for (int i = index; i < A.length; i++) {
                    sum += A[i];
                    if (max < sum) {
                        max = sum;
                    }
                }
                index++;
            }
            if (index == A.length) {

            }
            return max;
    }

    public static void help(int[] A, int start, int sum, int max) {

    }

    public static void main(String[] args) {
        int[] input = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(input));
    }
}
