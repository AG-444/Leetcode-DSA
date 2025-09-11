// Last updated: 9/11/2025, 4:08:26 PM
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        System.out.println(map);

        int count=0;
        if(k==0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(map.get(entry.getKey()+k)>=2){
                    count++;
                }
            }
        }
        else{
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(map.containsKey(entry.getKey()+k)){
                    count++;
                }
            }

        }



        return count;
    }
}