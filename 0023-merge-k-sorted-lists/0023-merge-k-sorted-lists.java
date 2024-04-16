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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        ListNode head = lists[0];
        for(int i = 1; i < lists.length; i++)
            head = merge(head,lists[i]);
        
        return head;
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode h1 = head1, h2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(h1!=null && h2!=null){
            if(h1.val <= h2.val){
                curr.next = new ListNode(h1.val);
                h1 = h1.next;
            }
            else{
                curr.next = new ListNode(h2.val);
                h2 = h2.next;
            }
            curr = curr.next;
        }
        if(h1!=null)
            curr.next = h1;
        if(h2!=null)
            curr.next = h2;
        return dummy.next;
    }
}