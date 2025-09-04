// Last updated: 9/4/2025, 1:01:44 PM
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int modulo = (int)1e9 + 7;
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            int min=arr[i];
            for(int j=i;j<n;j++){
                if(arr[j]<min){
                    min = arr[j];
                }
                sum += min;
            }
            sum = sum%modulo;
        }
        return sum%modulo;
    }
}