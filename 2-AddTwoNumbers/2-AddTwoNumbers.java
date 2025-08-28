// Last updated: 8/28/2025, 9:59:03 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify result list creation
        ListNode current = dummyHead;
        int carry = 0;

        // Loop through both lists until both are null and carry is 0
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;  // Get value from l1 or 0
            int val2 = (l2 != null) ? l2.val : 0;  // Get value from l2 or 0

            int sum = val1 + val2 + carry;  // Total sum at this digit
            carry = sum / 10;               // Carry for next digit

            current.next = new ListNode(sum % 10);  // Create new node with single-digit sum
            current = current.next;

            // Move to next nodes if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;  // First node is dummy, so return next
    }
}
