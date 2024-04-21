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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode sorted = new ListNode();

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode sort = sorted;

        while (curr1 != null && curr2!=null) {
            if (curr1.val <= curr2.val) {
                sort.next = new ListNode(curr1.val, null);
                curr1 = curr1.next;
            }
            else {
                sort.next = new ListNode(curr2.val, null);
                curr2 = curr2.next;
            }
            sort = sort.next;
        }

        while (curr1!=null) {
            sort.next = new ListNode(curr1.val);
            curr1 = curr1.next;
            sort = sort.next;
        }

        while (curr2!=null) {
            sort.next = new ListNode(curr2.val);
            curr2 = curr2.next;
            sort = sort.next;
        }

        return sorted.next;
    }

}