// Last updated: 9/17/2025, 9:23:01 AM
class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],arr[i]);
        }
        int[] suffix = new int[n];
        suffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1],arr[i]);
        }
        int total = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<prefix[i] && arr[i]<suffix[i]){
                total += Math.min(prefix[i],suffix[i]) - arr[i];
            }
        }

        return total;
    }
}