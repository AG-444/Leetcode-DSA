// Last updated: 9/14/2025, 11:53:34 AM
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(sb.length()<=10000){
            if(sb.indexOf(b) == -1){
                sb.append(a);
                i++;
            }
            else{
                return i;
            }
        }
        return -1;
    }
}