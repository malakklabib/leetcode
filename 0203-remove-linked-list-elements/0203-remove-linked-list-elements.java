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
        ListNode p = new ListNode(-1), c = head;
        p.next = c;
        while(c!=null){
            if(c.val==val){
                if(p.val==-1){
                    head = c.next;
                    c = head;
                }
                else{
                    p.next = c.next;
                    c = p;
                }
            }
            else{
                p = c;
                c = c.next;
            }
        }
        return head;
    }
}