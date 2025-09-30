// Last updated: 9/30/2025, 8:02:11 PM
class Solution {
    public int triangularSum(int[] nums) {
        int ans = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int n : nums) {
            q1.offer(n);
        }
        Queue<Integer> q2 = new LinkedList<>();
        while(q1.size() > 1){    
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                int a = q1.poll();
                int b = q1.peek();
                q2.offer((a+b)%10);
            }
            q1.clear();
            q1.addAll(q2);
            q2.clear();
        }

        return q1.peek();
    }
}