// Last updated: 9/17/2025, 9:49:40 AM
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y){
            return false;
        }
        
        if (target == 0){
            return true;
        }
        
        return target % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        while (y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        
        return x;
    }
}