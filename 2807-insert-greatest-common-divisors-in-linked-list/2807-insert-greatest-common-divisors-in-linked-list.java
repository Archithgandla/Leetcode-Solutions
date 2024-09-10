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
    
    public int GCD(int a,int b){

        if(a>b)
            return GCD(b,a);
        
        int temp = b;
        while(temp>=1){
            if(a%temp == 0 && b%temp == 0)
                return temp;
            temp-=1;
        }
        return temp;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
            
        ListNode temp = head;

        while(temp.next != null){
            ListNode next = temp.next;
            temp.next = new ListNode(GCD(temp.val,next.val));
            temp.next.next = next;
            temp = next;
        }

        return head;
    }
}






