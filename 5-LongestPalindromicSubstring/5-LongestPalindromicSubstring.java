// Last updated: 9/4/2025, 10:49:08 AM
class Solution {
    public String longestPalindrome(String s) {
        int centers = 2*s.length() -1;
        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<centers;i++){
            int left = i/2;
            int right = left+(i%2);
            StringBuilder substring = new StringBuilder();
            while(left>=0 && right<sb.length() && s.charAt(left) == s.charAt(right)){
                if(s.charAt(left) == s.charAt(right)){
                    substring = new StringBuilder(sb.substring(left,right+1));
                }
                left--;
                right++;
            }
            if(substring.length() > max){
                max = substring.length();
                ans = substring;
            }
        }   
        return ans.toString();
    }
}