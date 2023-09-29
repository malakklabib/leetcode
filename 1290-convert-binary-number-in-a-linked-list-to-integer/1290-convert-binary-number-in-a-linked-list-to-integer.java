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
    public int getDecimalValue(ListNode head) {
        ListNode t = head;
        int count = -1;
        while(t!=null){
            count++;
            t = t.next;
        }
        int res = 0;
        t = head;
        for(int i = count; i > -1; i--){
            if(t.val == 1)
                res+=Math.pow(2, i);
            t = t.next;
        }
        return res;
    }
}