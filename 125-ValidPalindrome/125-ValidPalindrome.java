// Last updated: 8/28/2025, 9:58:28 AM
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        boolean check = true;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if(!Character.isLetterOrDigit(sb.charAt(i))){
                sb.deleteCharAt(i);
            }
            else if(Character.isUpperCase(sb.charAt(i))){
                sb.setCharAt(i,Character.toLowerCase(sb.charAt(i)));
            }
        }
        
        return sb.toString().equals(sb.reverse().toString());
    }
}