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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode temp = list1,prev = null;
        b-=a;
        
        while(a>0 && temp != null){
            
            if(a == 1)
                prev = temp;
            
            temp = temp.next;
            a-=1;
        }
        
        
        if(prev != null)
            prev.next = list2;
        else
            list1 = list2;
        
        
        while(list2.next != null)
            list2 = list2.next;
        
        while(b>0 && temp != null){
            temp = temp.next;
            b-=1;
        }
        
        if(temp != null)
            list2.next = temp.next;
        
        return list1;
        
    }
}








