class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode f = new ListNode(-1), l = head, p, c, n;
        f.next = head;
        for(int i = 1; i<left; i++)
            f = f.next;
        for(int i = 1; i<right; i++)
            l = l.next;
        p = f.next;
        c = p.next;
        n = c.next;
        f.next = l;
        p.next = l.next;
        c.next = p;
        while(c!=l){
            p = c;
            c = n;
            n = n.next;
            c.next = p;
        }
        return left==1? l : head;
    }
}
