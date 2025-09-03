// Last updated: 9/3/2025, 5:12:51 PM
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int left = 0;
        int right = 1;
        while(left<=right && right<n){
            int a = prices[right] - prices[left];
            if(a>max) max = a;
            else if(prices[right] < prices[left]){
                left = right;
                right++;
            }
            else{
                right++;
            }
        }
        return max;
    }
}