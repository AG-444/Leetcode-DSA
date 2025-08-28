// Last updated: 8/28/2025, 9:58:45 AM
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String[] strs2 = new String[strs.length];
        for(int i =0 ;i<strs.length;i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            strs2[i] = new String(chs);
        }

        for(int i=0;i<strs2.length;i++){
            if(strs2[i] == "-1"){
                continue;
            }
            List<String> ans = new ArrayList<>();
            ans.add(strs[i]);
            for(int j=i+1;j<strs2.length;j++){
                if(strs2[i].equals(strs2[j])){
                    ans.add(strs[j]);
                    strs2[j] = "-1";
                }
            }
            result.add(ans);
        }
        return result;
    }
}