// Last updated: 9/16/2025, 10:52:25 PM
class Solution {
    public Map<Character,String> map = new HashMap<>();
    {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public void backTrack(String digits, int idx, StringBuilder curr, List<String> ans){
        if(digits.length() == idx){
            ans.add(new String(curr.toString()));
            return;
        }
        String s = map.get(digits.charAt(idx));
        for(char ch: s.toCharArray()){
            curr.append(ch);
            backTrack(digits, idx+1, curr, ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        backTrack(digits,0,new StringBuilder(),ans);
        return (ans);
    }
}