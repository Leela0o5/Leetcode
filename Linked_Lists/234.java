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
    public ListNode midNode(ListNode head){
        ListNode slow= head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode revLL(ListNode head){
        if(head == null || head.next==null) return head;
             ListNode temp = head;
             ListNode before = null;
             while(temp!=null){
                ListNode after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;
             }
             return before;

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode middle = midNode(head);
        // Reverse the second half
        ListNode head2 = revLL(middle);
        ListNode head1 = head;
        ListNode temp2 = head2;
        while(temp2!=null){
            if(head1.val!=temp2.val) return false;
            head1 = head1.next;
            temp2 = temp2.next;
        }
       return true;
        
    }
}
