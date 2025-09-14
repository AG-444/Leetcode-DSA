// Last updated: 9/14/2025, 12:06:56 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        else{
            char[] s1=s.toCharArray();
            char[] s2=t.toCharArray();
           
            Arrays.sort(s1);
            Arrays.sort(s2);

            if(Arrays.equals(s1,s2)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}