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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode fast = head, slow = head, prv = new ListNode(-1);
        prv.next = slow;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prv = prv.next;
            slow = slow.next;
        }
        prv.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left,right);
    }
    
    public ListNode merge(ListNode a, ListNode b){
        ListNode c = new ListNode(-1);
        ListNode head = c;
        ListNode currA = a, currB = b;
        
        while(currA!=null && currB!=null){
            if(currA.val>currB.val){
                c.next = new ListNode(currB.val);
                currB = currB.next;
            }
            else{
                c.next = new ListNode(currA.val);
                currA = currA.next;
            }
            c = c.next;
        }
        
        c.next = currA==null? currB : currA;
        
        return head.next;
    }
}








