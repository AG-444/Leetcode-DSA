// Last updated: 8/28/2025, 9:58:30 AM
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result(numRows);
        for(int i=1;i<numRows+1;i++){
            int ans= 1;
            result[i-1].push_back(1);
            for(int j=1;j<i;j++){
                ans = ans * (i-j)/j;

                result[i-1].push_back(ans);
            }
        }
        return result;
    }
};