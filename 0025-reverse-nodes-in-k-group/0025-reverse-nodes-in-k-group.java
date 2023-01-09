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

    ListNode Util(ListNode head,int k){
        if(head == null)
            return null;

        int count = k;
        ListNode h = head;
        
        
        
        //To check wheter k nodes are remaining
        while(count>0 && h!=null){
            h = h.next;
            count-=1;
        }

        if(count>0 && h == null)
            return head;

        
        //When k or more than k nodes are remaining
        count = k;
        ListNode curr = head,next = head,prev = null;
        while(count>0 && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count-=1;
        }

        head.next = Util(curr,k);
        return prev;

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        return Util(head,k);
    }
}