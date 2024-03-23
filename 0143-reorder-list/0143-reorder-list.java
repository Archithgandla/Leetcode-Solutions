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
    
    
    public ListNode Middle(ListNode head){
        
        ListNode slow = head,fast = head;
        
        while(fast != null && fast.next != null){
                
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;    
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode prev = null,curr = head,next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
    }
    
    
    public void reorderList(ListNode head) {
        
        ListNode mid = Middle(head);
        ListNode head2 = reverse(mid);
        ListNode ans = head;
        boolean flag = true;
        
        
        while(head != null && head2 != null){
            
            if(flag){
                
                ListNode next = head.next;
                head.next = head2;
                head = next;
                flag = !flag;
            }
            
            ListNode next = head2.next;
            head2.next = head;
            head2 = next;
            flag = !flag;
        }
        
        if(head != null)
            head.next = null;
        
        //return ans;
        
    }
}








