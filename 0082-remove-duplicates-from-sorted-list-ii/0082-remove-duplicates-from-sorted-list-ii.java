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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        if(head.next.next==null && head.val==head.next.val)
            return null;
        ListNode p = new ListNode(-1);
        ListNode c = head;
        while(c!=null && c.next!=null){
            p.next = c;
            if(c.val==c.next.val){
                ListNode t = c.next;
                while(t!=null && c.val==t.val)
                    t = t.next;
                if(c==head){
                    head = t;
                    c = head;
                }
                else{
                    p.next = t;
                    c = p.next;
                }
            }
            else{
                p = p.next;
                c = p.next; 
            }
        }
        return head;
    }
}