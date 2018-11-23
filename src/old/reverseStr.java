package old;

public class reverseStr {
    public static String reverseStr2(String s, int k) {
        return reverse(s.substring(0, k));
    }

    public static String reverse(String s) {
        char[] schar = s.toCharArray();
        int i = 0, j = schar.length - 1;
        while (i < j) {
            char tmp = schar[i];
            schar[i] = schar[j];
            schar[j] = tmp;
        }
        return schar.toString();
    }

    public static String reverseStr(String s, int k) {
        char[] schar = s.toCharArray();
        int n = schar.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(schar, i, j);
            i += 2 * k;
        }
        return String.valueOf(schar);
    }

    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
    public static void main(String [ ] args)
    {
        String s = "abcdefg";

        System.out.println("leetcode.Aug.reverseStr: " + reverseStr(s, 2));
    }
}
