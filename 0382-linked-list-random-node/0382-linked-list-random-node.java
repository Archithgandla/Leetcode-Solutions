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

    //Method - I
    //Time : 1 and space : O(N)
    //This approach code is written
    
    //Method-II Reservoir sampling
    //https://www.youtube.com/watch?v=9vC4I5sKFsw
    //Time : 1 and space : O(1)
    //I didn't understand this approach
    //https://www.youtube.com/watch?v=9vC4I5sKFsw
    //Refer above youtube video for MII explanation
    
    Random random; 
    ArrayList<Integer> Al;
    
    public Solution(ListNode head) {
        random= new Random();
        Al = new ArrayList<>();
        
        while(head != null){
            Al.add(head.val);
            head = head.next;
        }
        
    }
    
    public int getRandom() {
        return Al.get(random.nextInt(Al.size()));        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */