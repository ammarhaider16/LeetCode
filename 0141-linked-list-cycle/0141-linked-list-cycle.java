/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
        public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        Map nodes = new HashMap<ListNode, Integer>();
        while (head.next != null) {
            if (nodes.containsKey(head.next))
                return true;
            else
                nodes.put(head, 0);
            head = head.next;
        }
        return false;
    }
}