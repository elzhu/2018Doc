package old;

public class maxDistToClosest {
    public static int maxDistToClosest(int[] seats) {
        int dist = Integer.MIN_VALUE;
        int j = -1;
        if(seats[0] == 1) j = 0;
        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (j == -1) {
                    dist = Math.max(dist, i);
                } else {
                    dist = Math.max(dist, (i - j) /2);
                }
                   j = i;
            }
        }
        if(seats[seats.length - 1] == 0)
            dist = Math.max(dist , seats.length - 1 - j);
        return dist;
    }

    public static void main(String [ ] args)
    {
        int[] prices = {1,0,0,0};

        System.out.println("leetcode.Aug.maxDistToClosest: " + maxDistToClosest(prices));
    }
}
