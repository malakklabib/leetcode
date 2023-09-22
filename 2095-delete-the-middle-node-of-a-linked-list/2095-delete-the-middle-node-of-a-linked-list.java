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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)
            return null;
        ListNode slow = head, fast= head, p = new ListNode(-1);
        p.next = head;
        while(fast!=null && fast.next!=null){
            p = p.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = slow.next;
        return head;
        
    }
}