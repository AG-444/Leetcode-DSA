// Last updated: 8/28/2025, 9:57:47 AM
class Solution {
public:
    int count;
    int countOdds(int low, int high) {
        if (high%2==1){
            return (high/2-low/2+1);
        }
        else{return high/2-low/2;};
    }
};