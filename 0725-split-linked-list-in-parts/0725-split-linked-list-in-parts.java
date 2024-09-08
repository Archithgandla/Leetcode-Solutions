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


    public ListNode Util(ListNode head,int perPart){

        perPart-=1;

        while(perPart>0){
            head = head.next;
            perPart-=1;
        }
        ListNode next = head.next;
        head.next = null;

        return next;
    }


    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode temp = head;
        int count = 0;

        while(temp != null){
            count+=1;
            temp = temp.next;
        }

        int perPart = count/k,idx = 0;
        int remain = count-((count/k)*k);
        ListNode[] ans = new ListNode[k];

        while(head != null){
            ans[idx] = head;
            head = Util(head,perPart+(remain>0?1:0));       
            idx+=1;
            remain-=1;
        }

        return ans;
    }
}







