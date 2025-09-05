// Last updated: 9/5/2025, 7:07:51 PM
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch='a';ch<='z';ch++){
            map.put(ch,0);
        }
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = left + s1.length();
        while(right<=s2.length()){
            String sub = s2.substring(left,right);
            HashMap<Character, Integer> curr = new HashMap<>(map);
            int count = 0;
            for(char ch:sub.toCharArray()){
                if(curr.get(ch)<=0){
                    continue;
                }
                else if(curr.get(ch)>0){
                    curr.put(ch,curr.get(ch)-1);
                    count++;
                }
            }
            if(count == s1.length()) return true;
            left++;
            right++;
        }
        return false;
    }
}