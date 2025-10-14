// Last updated: 10/14/2025, 3:27:08 PM
class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = split.length - 1; i >=0; i--){
            if(!split[i].isEmpty()){
                sb.append(split[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}