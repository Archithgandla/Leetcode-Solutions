
class Node{
    
    Node next;
    String val;
    
    Node(String val){
        this.val = val;
    }
    
}


class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        HashMap<String,Node> hm = new HashMap<>();
        Node ref = new Node("-");
        Node head = ref;
        
        for(String str:arr){
            
            if(hm.containsKey(str)){
                hm.get(str).val = "!";
                continue;
            }
            
            Node newNode = new Node(str);
            hm.put(str,newNode);
            head.next = newNode;
            head = head.next;
        }
        
        ref = ref.next;
        
        while(k>0 && ref != null){
            
            if(ref.val != "!")
                k-=1;
            if(k == 0)
                return ref.val;
            ref =  ref.next;
        }
        
        return "";  
        
    }
}








