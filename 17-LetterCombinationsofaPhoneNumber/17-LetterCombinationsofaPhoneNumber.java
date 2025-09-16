// Last updated: 9/16/2025, 10:20:25 PM
class Solution {
    static Map<Character,String> map = new HashMap<>();
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
    public void backtrack(String digits, int idx, StringBuilder curr, List<String> result){
        if(idx == digits.length()){
            String s = curr.toString();
            result.add(s);
            return;
        }

        String a = map.get(digits.charAt(idx));
        for(char ch:a.toCharArray()){
            curr.append(ch);
            backtrack(digits,idx+1,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        backtrack(digits, 0 ,new StringBuilder(), ans);
        return  ans;
    }
}