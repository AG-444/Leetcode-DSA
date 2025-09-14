// Last updated: 9/14/2025, 11:56:29 AM
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(sb.length()<b.length()){
            i++;
            sb.append(a);
        }

        if(sb.indexOf(b) != -1) return i;

        sb.append(a);
        i++;
        if(sb.indexOf(b)!=-1) return i;

        
        return -1;
    }
}