// Last updated: 10/13/2025, 9:11:26 PM
class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int zeros = freq[0];
        int ones = freq[1];
        for(int i=0;i<zeros;i++){
            nums[i] = 0;
        }
        for(int i=zeros;i<ones+zeros;i++){
            nums[i] = 1;
        }
        for(int i=ones+zeros;i<nums.length;i++){
            nums[i] = 2;
        }
    }
}