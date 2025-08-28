// Last updated: 8/28/2025, 9:58:08 AM
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No change needed for empty or single-node lists
        }

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next; // Move odd pointer

            even.next = odd.next;
            even = even.next; // Move even pointer
        }

        odd.next = evenHead; // Connect odd list with even list
        return head;
    }
}
