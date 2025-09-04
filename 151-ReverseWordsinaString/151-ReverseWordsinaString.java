// Last updated: 9/4/2025, 11:05:11 AM
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty()) return "";
        
        String[] parts = s.split("\\s+");
        String[] rev = new String[parts.length];
        for(int i=0;i<parts.length;i++){
            rev[parts.length-1-i] = parts[i];
        }
        String result = String.join(" ", rev);
        return result;
    }
}