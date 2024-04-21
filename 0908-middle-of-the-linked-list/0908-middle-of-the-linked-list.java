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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        ListNode countNode = head;
        while (countNode != null) {
            length++;
            countNode = countNode.next;
        }

        int loopTill = length / 2;
        ListNode toReturn = head;

        for (int i = 0; i < loopTill; i++) {
            toReturn = toReturn.next;
        }
        return toReturn;
    }
}