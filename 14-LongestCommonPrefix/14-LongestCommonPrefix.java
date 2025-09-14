// Last updated: 9/14/2025, 11:48:22 AM
class Solution {
    public String longestCommonPrefix(String[] strs) {
       if(strs.length == 1) return strs[0];
       int left=0;
       int right=1;
       int common = Integer.MAX_VALUE;
       while(right<strs.length){
        int i = 0;
        while(i<strs[left].length() && i<strs[right].length() && strs[left].charAt(i) == strs[right].charAt(i)){
            i++;
        } 
        if(i<common){
            common = i;
        }
        left++;
        right++;
       }
       return strs[0].substring(0,common);
    }
}