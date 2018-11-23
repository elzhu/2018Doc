package bigf.BinarySearch;

public class searchRange {

    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1, -1};
        if(A == null || A.length == 0) {
            return res;
        }
        int start = firstGreaterEqual(A, target);
        if (A[start] != target || start == A.length) {
            return res;
        }
        res[0] = start;
        res[1] = firstGreaterEqual(A, target + 1) - 1;
        return res;
    }

    private static int firstGreaterEqual(int[] A, int target) {
        int left = 0;
        int right = A.length;
        while (left < right) {
            int middle = (right + left)/2;
            if (A[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
