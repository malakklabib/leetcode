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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, c = head;
        while(c!=null){
            if(c.val==val)
                p.next = c.next;
            else
                p = c;
            c = c.next;
        }
        return dummy.next;
    }
}