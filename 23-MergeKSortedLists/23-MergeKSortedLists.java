// Last updated: 8/28/2025, 9:58:53 AM
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


import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add initial nodes of all non-empty lists to the heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while (!heap.isEmpty()) {
            ListNode current = heap.poll();
            tail.next = current;
            tail = tail.next;
            
            // Add the next node from the same list to the heap
            if (current.next != null) {
                heap.offer(current.next);
            }
        }
        
        return dummy.next;
    }
}