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

    ListNode split(ListNode head,int dist){
        
        
        while(dist>1){
            head = head.next;
            dist-=1;
        }

        ListNode nextHead = head.next;
        head.next = null;

        return nextHead;
    }



    public ListNode[] splitListToParts(ListNode head, int k) {

        int len = 0;
        ListNode temp = head;

        while(temp != null){
            len+=1;
            temp = temp.next;
        }

        //case-1 : k == len then divide then nodes into k nodes
        //case-2 : k>len then split the list into k nodes and remaining null
        //case-3 : k<len then 
        //         len%k == 0 then just split the list into len/k pieces
        //         len%k != 0 then for 
        //

        ListNode[] ans = new ListNode[k];
        temp = head;

        if(k == len || k>len){
            ListNode next = null;
            int index = 0;

            while(temp != null){
                ans[index] = temp;
                temp = split(temp,1);
                index+=1;
            }
            return ans;
        }

        if(len%k == 0){

            int split_size = len/k,index = 0;            
            int curr = k;

            while(curr>0){
                ans[index] = temp;
                temp = split(temp,split_size);
                index+=1;
                curr-=1;
            }

            return ans;

        }
        else{

            int split_size = len/k;
            int extra = len%k,index = 0;

            while(extra>0){
                ans[index] = temp;
                temp = split(temp,split_size+1);
                index+=1;
                extra-=1;
            }

            int remain = k-extra;

            while(remain>0 && index<ans.length){
                ans[index] = temp;
                temp = split(temp,split_size);
                index+=1;
                remain-=1;           
            }

            return ans;
        }

        // return null;

    }
}



