// Last updated: 9/14/2025, 12:07:12 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] st = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(st);
        Arrays.sort(tt);
        return new String(st).equals(new String(tt));
        

    }
}