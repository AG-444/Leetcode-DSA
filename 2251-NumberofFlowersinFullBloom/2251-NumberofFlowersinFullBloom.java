// Last updated: 9/12/2025, 8:48:09 AM
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Comparator<int[]> comp = (a,b) ->{
            if(a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }
            else{
                return Integer.compare(a[0],b[0]);
            }
        };
        //0 = flower start;
        //1 = person arrived;
        //2 = flowers finished;

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        for(int i=0;i<flowers.length;i++){
            pq.offer(new int[]{0,flowers[i][0]});
            pq.offer(new int[]{2,flowers[i][1]}); 
        }
        for(int i=0;i<people.length;i++){
            pq.offer(new int[]{1,people[i],i});
        }
        int count=0;
        int[] result =new int[people.length];
        
        while(pq.peek()!=null){
            int[] curr = pq.poll();
            if(curr[0] == 0){
                count++;
            }
            else if(curr[0]==1){
                result[curr[2]] = count;
            }
            else{
                count--;
            }
        }
        
        return result;
    }
}