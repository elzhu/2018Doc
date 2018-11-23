package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class reconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            System.out.println("k[0]: " + k[0]);
            System.out.println("k[1]: " + k[1]);
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }
        return res;
    }
    public static void main(String [ ] args)
    {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        System.out.println("leetcode.Aug.reconstructQueue: " + reconstructQueue(people));
    }
}
