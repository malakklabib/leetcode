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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head; 
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        int ans = 0;
        while(l1!=null && l2!=null){
            ans = Math.max(ans, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head, prv = null, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr = next;
        }
        return prv;
    }
}