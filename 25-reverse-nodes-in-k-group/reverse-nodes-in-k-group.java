class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if we have at least k nodes
        ListNode ptr = head;
        for (int i = 0; i < k; i++) {
            if (ptr == null) return head; // Not enough nodes
            ptr = ptr.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // After reversing, head becomes the end of this group.
        // Connect it to the next group's reversed result
        head.next = reverseKGroup(curr, k);

        // Return new head (which was the k-th node before reversal)
        return prev;
    }
}
