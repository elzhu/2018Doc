package old;

public class maxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    public static void main(String [ ] args)
    {
        int[] prices = {3,2,6,5,0,3};

        System.out.println("leetcode.Aug.maxProfit: " + maxProfit(prices));
    }
}
