// Last updated: 8/28/2025, 9:57:52 AM
import java.util.*;
class Solution {
    public int maximum69Number (int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '6'){
                str.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(str.toString());
    }
}