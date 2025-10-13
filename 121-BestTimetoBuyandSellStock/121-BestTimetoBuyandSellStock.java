// Last updated: 10/13/2025, 9:26:06 PM
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int p : prices) {
            // if current price is a new minimum, consider buying here
            if (p < minPrice) {
                minPrice = p;
            } else {
                // otherwise, consider selling today
                int profitIfSoldToday = p - minPrice;
                if (profitIfSoldToday > maxProfit) {
                    maxProfit = profitIfSoldToday;
                }
            }
        }
        return maxProfit;
    }

    // quick main to test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));   // 0
    }
}
