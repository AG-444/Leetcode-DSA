// Last updated: 10/14/2025, 3:00:27 PM
class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> comp = (a,b) ->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        };
        PriorityQueue<int[]> pq =  new PriorityQueue<>(comp);

        for(int[] curr: intervals){
            pq.offer(curr);
        }

        int[] first = pq.poll();
        int start = first[0];
        int end = first[1];

        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length-1;i++){
            int[] curr = pq.poll();
            int newStart = curr[0];
            int newEnd = curr[1];
            if(start<=newStart && newStart<=end){
                // System.out.println(start+ " "+end);
                end = Math.max(end, newEnd);
                // System.out.println("new = " + start+ " "+end);
            }
            else{
                ans.add(new int[]{start,end});
                // System.out.println("added = " + start+ " "+end);
                start = newStart;
                end = newEnd;
            }
        }
        ans.add(new int[]{start,end});
        

        return ans.toArray(new int[ans.size()][]);

    }
}