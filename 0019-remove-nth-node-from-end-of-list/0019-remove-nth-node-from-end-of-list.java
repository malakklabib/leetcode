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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        ListNode s = head, f = head, p = new ListNode(-1);
        p.next = head;
        for(int i = 0; i < n; i++)
            f = f.next;
        while(f!=null){
            p = p.next;
            s = s.next;
            f = f.next;
        }
        p.next = s.next;
        return p.val==-1? p.next : head;
        
    }
}