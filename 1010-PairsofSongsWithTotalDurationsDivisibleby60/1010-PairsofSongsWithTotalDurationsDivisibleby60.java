// Last updated: 9/11/2025, 8:06:19 PM
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n= time.length;
        int[] arr = new int[60];
        int ans = 0;

        for(int i=0;i<n;i++){
            int rem = time[i]%60;
            int other = (60 - rem) % 60;
            ans += arr[other];   // count pairs directly
            arr[rem]++;
        }
        
        
        // for(int i=0;i<n;i++){
        //     arr[time[i]] -=1;
        //     int other = (60-time[i])%60;

        //     if(arr[other] >0){
        //         System.out.println(other+ " - "+ arr[other]);
        //         ans += arr[other];
        //         arr[other] = 0;
        //         // ans += arr[60-(time[i])];
        //         // arr[60-(time[i])] = 0;
        //     }
        // }
        
        return ans;

    }
}