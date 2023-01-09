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


//Approach - 1
//Time : O(n)
//Space : O(1)
//Watch striver : pending









//Approach - 2
//Time : O(n)
//Space : O(n)
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


//Approach - 3
// class Solution {
//     public Node copyRandomList(Node head) {
//         HashMap<Node,Integer> hm = new HashMap<>();

//         Node temp = head;

//         int index = 0;
//         while(temp != null){
//             hm.put(temp,index);
//             index+=1;
//             temp = temp.next;
//         }
//         System.out.println(hm);

//         int[] randoms = new int[hm.size()];
//         temp = head;
//         index = 0;

//         while(temp != null){

//             if(temp.random == null){
//                 randoms[index] = Integer.MAX_VALUE;
//                 index+=1;
//                 temp = temp.next;
//                 continue;
//             }


//             randoms[index] = hm.get(temp.random);
//             index+=1;
//             temp = temp.next;
//         }

//         Node[] arr = new Node[randoms.length];
//         Node dummy = new Node(-1);
//         Node t = dummy;
//         temp = head;
//         index = 0;

//         while(temp != null){
//             t.next = new Node(temp.val);
//             t = t.next;
//             temp = temp.next;

//             arr[index] = t;
//             index+=1;
//         }

//         t = dummy.next;
//         index = 0;

//         while(t != null){

//             if(randoms[index] == Integer.MAX_VALUE){
//                 index+=1;
//                 t = t.next;
//                 continue;
//             }
//             t.random = arr[randoms[index]];
//             t = t.next;
//             index+=1;
//         }
//         return dummy.next;
//     }
// }

