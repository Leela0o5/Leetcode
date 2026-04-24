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
    public int numNodes(ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr!=null) {count++;curr = curr.next;}
        return count;
    } 
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int totalNodes = numNodes(head);
        k = k % totalNodes;
        if(k==0) return head;
        ListNode tempHead = head;
        ListNode temp =  head;
        for(int i=0;i<totalNodes-k-1;i++){
             temp = temp.next;
        }
        ListNode resNode = temp.next;
        temp.next = null;

        ListNode tailFinder = resNode;
        while(tailFinder.next!=null) {
            tailFinder=tailFinder.next;
        }
        tailFinder.next = tempHead;
         return resNode;
        
    }
   
}
