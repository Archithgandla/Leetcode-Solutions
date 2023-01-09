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
        HashMap<Node,Node> hm = new HashMap<>();
        
        Node temp = head,dummy = new Node(-1);
        Node copy = dummy;
        
        //Cloning ll except random pointers
        while(temp != null){
            Node curr = new Node(temp.val);
            copy.next = curr;
            copy = copy.next;
            hm.put(temp,copy);
            temp = temp.next;
        }
        
        //Cloning random pointers
        temp = head;
        copy = dummy.next;
        
        while(temp != null){
            
            if(temp.random != null)
                copy.random = hm.get(temp.random);
            temp = temp.next;
            copy = copy.next;
        }
        return dummy.next;
        
    }
}