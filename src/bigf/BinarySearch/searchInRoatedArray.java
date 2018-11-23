package bigf.BinarySearch;

public class searchInRoatedArray {
    public static int searchInRoatedArray(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;

        while(left < right) {
            int mid = (right + left)/2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] >= A[left]) {
                if (A[mid] > target && A[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && A[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return A[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] A = {4,5,6,1,2,3};
        System.out.println(searchInRoatedArray(A, 0));
    }
}
