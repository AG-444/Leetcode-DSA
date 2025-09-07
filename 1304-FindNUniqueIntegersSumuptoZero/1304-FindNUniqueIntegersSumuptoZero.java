// Last updated: 9/7/2025, 10:54:51 AM
class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int idx = 0;
        int curr = 1;
        while(n>1){
            arr[idx++] = curr;
            arr[idx++] = -curr;
            n -=2;
            curr++;
        }
        if(n==1) arr[arr.length-1] = 0;
        Arrays.sort(arr);
        return arr;

        
    }
}