class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            int gcd = getGCD(current.val, current.next.val);
            ListNode gcdNode = new ListNode(gcd);
            gcdNode.next = current.next;
            current.next = gcdNode;
            current = gcdNode.next; // Move two steps ahead
        }
        
        return head;
    }
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
