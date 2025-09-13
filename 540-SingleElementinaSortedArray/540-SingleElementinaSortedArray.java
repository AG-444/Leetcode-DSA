// Last updated: 9/13/2025, 3:29:58 PM
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while(low<high){
            int mid = (low+high)/2;
            if (mid % 2 == 1) mid--; // force mid to be even
            if (nums[mid] == nums[mid+1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}