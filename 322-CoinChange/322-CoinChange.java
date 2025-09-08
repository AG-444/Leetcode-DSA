// Last updated: 9/8/2025, 7:06:49 PM
class Solution {
    public int changeDp(int[] coins, int amount, int[] dp){
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount]; // avoid recomputation

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(amount - coins[i] >= 0){ // fix here
                int subAns = changeDp(coins, amount - coins[i], dp);
                if(subAns != Integer.MAX_VALUE){
                    ans = Math.min(ans, subAns + 1);
                }
            }
        }
        return dp[amount] = ans;
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int res = changeDp(coins, amount, dp);
        return res == Integer.MAX_VALUE ? -1 : res; // fix here
    }
}
