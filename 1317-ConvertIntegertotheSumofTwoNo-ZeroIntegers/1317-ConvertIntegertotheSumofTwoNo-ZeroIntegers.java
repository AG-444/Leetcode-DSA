// Last updated: 9/8/2025, 6:57:29 PM
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i=1;i<n;i++){
            Character[] a = String.valueOf(n - i).chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            Character[] b = String.valueOf(i).chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            if(!Arrays.asList(a).contains('0') && !Arrays.asList(b).contains('0')){
                ans =  new int[]{i,n-i};
            }
        }
        return ans;
    }
}