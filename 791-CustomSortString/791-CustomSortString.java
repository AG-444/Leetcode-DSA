// Last updated: 9/8/2025, 10:01:00 AM
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        StringBuilder string = new StringBuilder();
        StringBuilder notInOrder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                notInOrder.append(s.charAt(i));
            }
            else string.append(s.charAt(i));
        }

        char[] chars = string.toString().toCharArray();
        Character[] chrs = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            chrs[i] = chars[i];
        }
        Arrays.sort(chrs,(a,b)->{
            return Integer.compare(map.get(a), map.get(b));
        });
        string.setLength(0);
        for(char c:chrs){
            string.append(c);
        }
        string.append(notInOrder);

        return string.toString();
    }
}