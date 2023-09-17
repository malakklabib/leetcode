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
        ListNode d = head;
        while(d!=null && d.next!=null){
            if(d.val == d.next.val)
                d.next = d.next.next;
            else
                d = d.next;
        }
        return head;
    }
}