// Last updated: 9/14/2025, 12:03:15 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for(char ch: t.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        return map.equals(map2);
        
    }
}