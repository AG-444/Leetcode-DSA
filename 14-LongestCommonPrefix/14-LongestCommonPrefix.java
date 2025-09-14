// Last updated: 9/14/2025, 11:49:16 AM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
       if ( strs == null || strs.length == 0){
            return "";
       }

       String prefix = strs[0];

       for (int i = 1 ; i < strs.length ; i++){
            while ( strs[i].indexOf(prefix) != 0 ){
                prefix = prefix.substring( 0 , prefix.length() - 1);

                if (prefix.isEmpty()){
                    return "";
                }
            }
       }
       return prefix;
    }
}