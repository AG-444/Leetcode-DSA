// Last updated: 9/11/2025, 4:11:33 PM
class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length==0) return 0;

        return findP(nums,k);
    }

    protected int findP(int[] nums, int k)
    {
      Map<Integer,Integer> map = new HashMap<>();
      int counter=0;

      for(int i=0;i<nums.length;i++)
      {
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      }

      for(Map.Entry<Integer,Integer> entry:map.entrySet())
      { 
        int val = entry.getKey();
        int ke = val+k; //5
       // printMap(map);
       
        if(k>0 && map.containsKey(ke))
        {
            //System.out.println("The nums "+val);
             //System.out.println("The key "+ke);             
           counter++;       
           
        }
        else if((k==0) &&(map.get(ke)>1))
        {
            //System.out.println("In: The nums "+val);
             //System.out.println("In : The key "+ke);            
                counter++;
        }       
      }
      return counter;
       
    }

    protected void printMap(Map<Integer,Integer> map)
    {
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int key = entry.getKey();
            int val = entry.getValue();
            
               System.out.print(" key->" +key);
           
            System.out.println(" value "+val);
            
        }
    }
}