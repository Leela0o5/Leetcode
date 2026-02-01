/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode revLinkedList(ListNode head) {
        ListNode before = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
        }
        return before;

    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode midNode = middleNode(head);
        ListNode l2 = revLinkedList(midNode.next);
        midNode.next = null;
        ListNode l1 = head;

        // Merging 
        while (l1 != null && l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;

            l1.next = l2;
            l2.next = tmp1;

            l1 = tmp1;
            l2 = tmp2;
        }
    }
}
