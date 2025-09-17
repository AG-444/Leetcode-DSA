// Last updated: 9/17/2025, 9:45:19 AM
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(0);
        set.add(0);
        while(!queue.isEmpty()){
            int a = queue.poll();
            System.out.println(a);
            if(a+x>0 && a+x<=x+y){
                if(a+x == target) return true;
                if(!set.contains(a+x)){
                    set.add(a+x);
                    queue.add(a+x);
                };
            }
            if(a+y>0 && a+y<=x+y){
                if(a+y == target) return true;
                if(!set.contains(a+y)){
                    set.add(a+y);
                    queue.add(a+y);
                };
            }
            if(a-x>0 && a-x<=x+y){
                if(a-x == target) return true;
                if(!set.contains(a-x)){
                    set.add(a-x);
                    queue.add(a-x);
                };
            }
            if(a-y>0 && a-y<=x+y){
                if(a-y == target) return true;
                if(!set.contains(a-y)){
                    set.add(a-y);
                    queue.add(a-y);
                };
            }
        }
        return false;
    }
}