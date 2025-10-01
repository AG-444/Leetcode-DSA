// Last updated: 10/1/2025, 9:01:19 AM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return (numBottles + (numBottles - 1)/(numExchange - 1));
    }
}