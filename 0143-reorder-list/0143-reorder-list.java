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
    public void reorderList(ListNode head) {
        if(head.next==null)
            return;
        
        ListNode slow = head, fast = head, prv = null;
        while(fast!=null && fast.next!=null){
            prv = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prv.next = null;
        
        ListNode head1 = head;
        ListNode head2 = reverse(slow);
        while(head1!=null && head2!=null){
            ListNode t1 = head1.next;
            ListNode t2 = head2.next;
            
            head1.next = head2;
            if(t1==null) break;
            head2.next = t1;
            
            head1 = t1;
            head2 = t2;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head, next = null, prv = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr = next;
        }
        return prv;
    }
}