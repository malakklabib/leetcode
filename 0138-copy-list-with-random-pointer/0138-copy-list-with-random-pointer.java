/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        
        Map<Node, Node> nodes = new HashMap();
        
        Node curr = head;
        Node newHead = new Node(curr.val);
        Node newCurr = newHead;
        while(curr!=null){
            if(curr.next!=null)
                newCurr.next = new Node(curr.next.val);
            nodes.put(curr, newCurr);
            newCurr = newCurr.next;
            curr = curr.next;
        }
        
        curr = head;
        newCurr = newHead;
        while(curr!=null){
            newCurr.random = nodes.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        return newHead;
    }
}