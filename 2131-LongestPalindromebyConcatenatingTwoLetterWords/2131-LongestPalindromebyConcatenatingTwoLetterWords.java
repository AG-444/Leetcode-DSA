// Last updated: 9/11/2025, 8:32:55 PM
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int ans = 0;

        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        System.out.println(map);

        List<String> symm = new ArrayList<>();
        for(String str:words){
            if(str.charAt(0) == str.charAt(1)){
                if((map.get(str)>1 && map.get(str)%2 == 0)){
                    continue;
                }
                else{
                    symm.add(str);
                    map.put(str,map.get(str)-1);
                }
            }
        }  //gets center if odd existence symm exists

        if(symm.size() > 0){
            ans +=2;
        }
        
        for(String str:words){
            String rev = new StringBuilder(str).reverse().toString();
            if(map.containsKey(rev) && map.get(rev)>0 && map.get(str)> 0){
                ans += 4;
                map.put(str,map.get(str)-1);
                map.put(rev,map.get(rev)-1);
            }
        }


        return ans;
    }
}